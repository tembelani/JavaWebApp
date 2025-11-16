package dao;


import model.UserProfile;
import util.DatabaseConnection;

import java.sql.*;
import java.util.Optional;

public class UserProfileDAO {

    public boolean createOrUpdateProfile(UserProfile profile) {
        // Check if profile exists
        Optional<UserProfile> existing = findByUserId(profile.getUserId());

        if (existing.isPresent()) {
            return updateProfile(profile);
        } else {
            return createProfile(profile);
        }
    }

    private boolean createProfile(UserProfile profile) {
        String sql = "INSERT INTO user_profiles (user_id, phone, address, date_of_birth) VALUES (?, ?, ?, ?)";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, profile.getUserId());
            stmt.setString(2, profile.getPhone());
            stmt.setString(3, profile.getAddress());
            stmt.setDate(4, Date.valueOf(profile.getDateOfBirth()));

            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    private boolean updateProfile(UserProfile profile) {
        String sql = "UPDATE user_profiles SET phone = ?, address = ?, date_of_birth = ? WHERE user_id = ?";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, profile.getPhone());
            stmt.setString(2, profile.getAddress());
            stmt.setDate(3, Date.valueOf(profile.getDateOfBirth()));
            stmt.setInt(4, profile.getUserId());

            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public Optional<UserProfile> findByUserId(int userId) {
        String sql = "SELECT * FROM user_profiles WHERE user_id = ?";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, userId);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                UserProfile profile = new UserProfile();
                profile.setId(rs.getInt("id"));
                profile.setUserId(rs.getInt("user_id"));
                profile.setPhone(rs.getString("phone"));
                profile.setAddress(rs.getString("address"));

                Date dob = rs.getDate("date_of_birth");
                if (dob != null) {
                    profile.setDateOfBirth(dob.toLocalDate());
                }

                return Optional.of(profile);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return Optional.empty();
    }
}
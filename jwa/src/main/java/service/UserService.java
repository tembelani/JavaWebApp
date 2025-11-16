package service;

import dao.UserDAO;
import dao.UserProfileDAO;
import model.User;
import model.UserProfile;
import util.PasswordUtil;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.regex.Pattern;

public class UserService {
    private UserDAO userDAO;
    private UserProfileDAO profileDAO;

    public UserService() {
        this.userDAO = new UserDAO();
        this.profileDAO = new UserProfileDAO();
    }

    public boolean registerUser(User user, String plainPassword) {
        // Input validation
        if (!isValidUsername(user.getUsername()) ||
                !isValidEmail(user.getEmail()) ||
                !PasswordUtil.isValidPassword(plainPassword)) {
            return false;
        }

        // Check if username or email already exists
        if (userDAO.findByUsername(user.getUsername()).isPresent() ||
                userDAO.findByEmail(user.getEmail()).isPresent()) {
            return false;
        }

        // Hash password and save user
        user.setPasswordHash(PasswordUtil.hashPassword(plainPassword));
        return userDAO.createUser(user);
    }

    public Optional<User> authenticate(String username, String password) {
        Optional<User> userOpt = userDAO.findByUsername(username);

        if (userOpt.isPresent()) {
            User user = userOpt.get();
            if (PasswordUtil.checkPassword(password, user.getPasswordHash())) {
                return Optional.of(user);
            }
        }
        return Optional.empty();
    }

    public boolean updateUserProfile(User user, UserProfile profile) {
        // Input validation for profile data
        if (profile.getPhone() != null && !isValidPhone(profile.getPhone())) {
            return false;
        }

        // Update user basic info
        boolean userUpdated = userDAO.updateUser(user);

        // Update or create profile
        boolean profileUpdated = profileDAO.createOrUpdateProfile(profile);

        return userUpdated || profileUpdated;
    }

    public Optional<UserProfile> getUserProfile(int userId) {
        return profileDAO.findByUserId(userId);
    }

    public List<User> getAllUsers() {
        return userDAO.findAll();
    }

    // Input validation methods (OWASP security)
    private boolean isValidUsername(String username) {
        if (username == null || username.length() < 3 || username.length() > 50) {
            return false;
        }
        // Alphanumeric with underscores, no SQL injection patterns
        return Pattern.matches("^[a-zA-Z0-9_]+$", username) &&
                !username.toLowerCase().contains("select") &&
                !username.toLowerCase().contains("insert") &&
                !username.toLowerCase().contains("delete") &&
                !username.toLowerCase().contains("update");
    }

    private boolean isValidEmail(String email) {
        if (email == null) return false;
        String emailRegex = "^[A-Za-z0-9+_.-]+@(.+)$";
        return Pattern.matches(emailRegex, email);
    }

    private boolean isValidPhone(String phone) {
        if (phone == null) return true; // Phone is optional
        // Basic phone validation - adjust based on requirements
        return Pattern.matches("^[+]?[0-9\\s-()]{10,}$", phone);
    }
}
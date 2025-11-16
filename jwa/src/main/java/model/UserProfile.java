package model;

import java.time.LocalDate;

public class UserProfile {
    private int id;
    private int userId;
    private String phone;
    private String address;
    private LocalDate dateOfBirth;

    // Constructors, Getters and Setters
    public UserProfile() {}

    public UserProfile(int userId, String phone, String address, LocalDate dateOfBirth) {
        this.userId = userId;
        this.phone = phone;
        this.address = address;
        this.dateOfBirth = dateOfBirth;
    }

    // Getters and Setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public int getUserId() { return userId; }
    public void setUserId(int userId) { this.userId = userId; }

    public String getPhone() { return phone; }
    public void setPhone(String phone) { this.phone = phone; }

    public String getAddress() { return address; }
    public void setAddress(String address) { this.address = address; }

    public LocalDate getDateOfBirth() { return dateOfBirth; }
    public void setDateOfBirth(LocalDate dateOfBirth) { this.dateOfBirth = dateOfBirth; }
}

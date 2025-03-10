package com.example.sqltest;

public class User {
    private int id;
    private String fullName;
    private String email;
    private String phone;
    private String createdAt;

    public User(int id, String fullName, String email, String phone, String createdAt) {
        this.id = id;
        this.fullName = fullName;
        this.email = email;
        this.phone = phone;
        this.createdAt = createdAt;
    }

    public int getId() { return id; }
    public String getFullName() { return fullName; }
    public String getEmail() { return email; }
    public String getPhone() { return phone; }
    public String getCreatedAt() { return createdAt; }

    @Override
    public String toString() {
        return id + " - " + fullName + " - " + email;
    }
}

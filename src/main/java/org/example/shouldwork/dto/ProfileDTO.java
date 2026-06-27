package org.example.shouldwork.dto;

import java.io.Serializable;

public class ProfileDTO implements Serializable {
    private String id;
    private String username;
    private String email;
    private double height;
    private double weight;
    private String gender;
    private String password;
    // Constructor, Getters, Setters, and toString

    public ProfileDTO(String id, String username, String email, double height, double weight, String gender, String password) {
        this.id = id;
        this.username = username;
        this.email = email;
        this.height = height;
        this.weight = weight;
        this.gender = gender;
        this.password = password;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String Password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "ProfileDTO{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", email='" + email + '\'' +
                ", height=" + height +
                ", weight=" + weight +
                ", gender='" + gender + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}






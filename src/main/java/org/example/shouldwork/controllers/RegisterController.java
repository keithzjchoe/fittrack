/*
package org.example.shouldwork.controllers;

import org.example.shouldwork.dao.ProfileDAO;
import org.example.shouldwork.dto.ProfileDTO;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.control.PasswordField;
import javafx.scene.control.RadioButton;
import javafx.scene.image.ImageView;

public class RegisterController {
    @FXML private TextField usernameField;
    @FXML private TextField emailField;
    @FXML private PasswordField passwordField;
    @FXML private PasswordField confirmPasswordField;
    @FXML private TextField heightField;
    @FXML private TextField weightField;
    @FXML private TextField ageField;
    @FXML private RadioButton maleRadioButton;
    @FXML private RadioButton femaleRadioButton;
    @FXML private ImageView profilePicture;

    private final ProfileDAO profileDAO = new ProfileDAO();

    @FXML
    public void handleRegister() {
        String username = usernameField.getText();
        String email = emailField.getText();
        String password = passwordField.getText();
        String confirmPassword = confirmPasswordField.getText();
        int height = Integer.parseInt(heightField.getText());
        int weight = Integer.parseInt(weightField.getText());
        String gender = maleRadioButton.isSelected() ? "Male" : "Female";

        if (!password.equals(confirmPassword)) {
            System.out.println("Passwords do not match!");
            return;
        }

        ProfileDTO newProfile = new ProfileDTO("1", username, email, height, weight, gender);
        profileDAO.save(newProfile);

        System.out.println("User registered successfully!");
    }



}

*/
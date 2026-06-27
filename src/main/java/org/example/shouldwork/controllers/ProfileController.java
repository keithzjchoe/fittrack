package org.example.shouldwork.controllers;

import javafx.scene.control.Label;
import org.example.shouldwork.dao.ProfileDAO;
import org.example.shouldwork.dto.ProfileDTO;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

import java.util.List;

public class ProfileController {

    @FXML
    private Label usernameLabel;
    @FXML
    private Label emailLabel;
    @FXML
    private Label heightLabel;
    @FXML
    private Label weightLabel;
    @FXML
    private Label genderLabel;
    @FXML
    private Button saveChangesButton;
    private HelloApplication mainApp;

    private ProfileDAO profileDAO = new ProfileDAO();

    //Show scene
    public void setMainApp(HelloApplication mainApp) {
        this.mainApp = mainApp;
    }

    @FXML
    private void showLogIn() {
        mainApp.showScene("/org/example/shouldwork/LogIn.fxml");
    }

    @FXML
    private void showSignUp() {
        mainApp.showScene("/org/example/shouldwork/SignUp.fxml");
    }

    @FXML
    private void showSetUp() {mainApp.showScene("/org/example/shouldwork/SetUp.fxml");}

    @FXML
    private void showDashboard() {mainApp.showScene("/org/example/shouldwork/dashboard.fxml");}

    @FXML
    private void showDataOverview() {
        mainApp.showScene("/org/example/shouldwork/dataOverview.fxml");
    }

    @FXML
    private void showLogOut() {mainApp.showScene("/org/example/shouldwork/LogOut.fxml");}

    @FXML
    private void showMealLog() {
        mainApp.showScene("/org/example/shouldwork/mealLog.fxml");
    }

    @FXML
    private void showProfile() {
        mainApp.showScene("/org/example/shouldwork/Profile.fxml");
    }

    @FXML
    private void showSettings() {
        mainApp.showScene("/org/example/shouldwork/settings.fxml");
    }

    @FXML
    private void showWorkoutLog() {mainApp.showScene("/org/example/shouldwork/workoutLog.fxml");}

    @FXML
    private void addMeal_ML() {mainApp.showScene("/org/example/shouldwork/Add_Meal(Meal_Log).fxml");}

    @FXML
    private void showDailyCaloricIntake_ML() {mainApp.showScene("/org/example/shouldwork/Daily_Caloric_Intake_Goal(Meal_Log).fxml");}

    @FXML
    private void showAddRoutine() {mainApp.showScene("/org/example/shouldwork/Add_Routine(Workout_Log).fxml");}

    @FXML
    private void changeUsername() {
        mainApp.showScene("/org/example/shouldwork/changeUsername.fxml");
    }

    @FXML
    private void changeEmail() {
        mainApp.showScene("/org/example/shouldwork/changeEmail.fxml");
    }

    @FXML
    private void changeHeight() {
        mainApp.showScene("/org/example/shouldwork/changeHeight.fxml");
    }

    @FXML
    private void changeWeight() {
        mainApp.showScene("/org/example/shouldwork/changeWeight.fxml");
    }

    @FXML
    private void changeGoal() {
        mainApp.showScene("/org/example/shouldwork/changeGoal.fxml");
    }

    @FXML
    private void changeGender() {
        mainApp.showScene("/org/example/shouldwork/changeGender.fxml");
    }
    public ProfileController() {
        this.profileDAO = new ProfileDAO();
    }

    @FXML
    private Label usernameField;

    @FXML
    public void initialize() {
        // Fetch all profiles from the DAO
        List<ProfileDTO> profiles = profileDAO.getAll();

        // Assume the first profile is the one we want to display (modify this as needed)
        if (profiles.isEmpty()) {
            System.out.println("No profiles found to display.");
            return;
        }

        ProfileDTO profile = profiles.getFirst();
         usernameField.setText(profile.getUsername());

        // Fetch all profiles from the DAO

        // Assume the first profile is the one we want to display (modify this as needed)
        if (profiles.isEmpty()) {
            System.out.println("No profiles found to display.");
            return;
        }

        System.out.println(profile.getHeight());
        System.out.println(profile.getWeight());
        System.out.println(profile.getGender());
        // Populate labels with the profile's data
        usernameLabel.setText("Username: " + profile.getUsername());
        emailLabel.setText("Email: " + profile.getEmail());
        heightLabel.setText("Height: " + profile.getHeight() + " cm");
        weightLabel.setText("Weight: " + profile.getWeight() + " kg");
        genderLabel.setText("Gender: " + profile.getGender());

    }
    /*
    private void loadProfileData() {
        // Fetch profile data from the DAO (this should be from the logged-in user)
        ProfileDTO profile = profileDAO.getProfile();
        usernameLabel.setText(profile.getUsername());
        emailLabel.setText(profile.getEmail());
        heightLabel.setText(String.valueOf(profile.getHeight()));
        weightLabel.setText(String.valueOf(profile.getWeight()));
    }

     */
/*
    @FXML
    private void saveChanges() {
        // Get values from input fields
        String username = usernameField.getText();
        String email = emailField.getText();
        double height = Double.parseDouble(heightField.getText());
        double weight = Double.parseDouble(weightField.getText());

        // Create updated ProfileDTO
        ProfileDTO updatedProfile = new ProfileDTO("1", username, email, height, weight, "Male");

        // Save updated profile to DAO
        profileDAO.save(updatedProfile);

        // Show success message
        Alert alert = new Alert(AlertType.INFORMATION);
        alert.setTitle("Profile Updated");
        alert.setHeaderText(null);
        alert.setContentText("Your profile has been updated successfully.");
        alert.showAndWait();
    }

 */
}


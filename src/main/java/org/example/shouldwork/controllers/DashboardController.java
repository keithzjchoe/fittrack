package org.example.shouldwork.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import org.example.shouldwork.dao.ProfileDAO;
import org.example.shouldwork.dto.ProfileDTO;

import java.util.List;

public class DashboardController {
    @FXML private Label goalLabel;
    @FXML private Label caloriesLabel;
    @FXML private Label quoteLabel;
    @FXML
    private Label usernameField;
    private HelloApplication mainApp;
    private final ProfileDAO profileDAO = new ProfileDAO();


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
        mainApp.showScene("/org/example/shouldwork/Settings.fxml");
    }

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

    @FXML
    private void showWorkoutLog() {mainApp.showScene("/org/example/shouldwork/workoutLog.fxml");}

    @FXML
    private void addMeal_ML() {mainApp.showScene("/org/example/shouldwork/Add_Meal(Meal_Log).fxml");}

    @FXML
    private void showDailyCaloricIntake_ML() {mainApp.showScene("/org/example/shouldwork/Daily_Caloric_Intake_Goal(Meal_Log).fxml");}

    @FXML
    private void showAddRoutine() {mainApp.showScene("/org/example/shouldwork/Add_Routine(Workout_Log).fxml");}

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


    }

}
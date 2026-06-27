package org.example.shouldwork.controllers;

import javafx.fxml.FXML;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Label;
import org.example.shouldwork.dao.ProfileDAO;
import org.example.shouldwork.dao.WorkoutLogDAO;
import org.example.shouldwork.dto.Exercise;
import org.example.shouldwork.dto.Food;
import org.example.shouldwork.dto.ProfileDTO;

import java.io.File;
import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.util.List;

public class DataOverviewController {

    private HelloApplication mainApp;
    private final WorkoutLogDAO workoutLogDAO;
    public DataOverviewController() {
        this.workoutLogDAO = new WorkoutLogDAO();
    }
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

    @FXML
    private BarChart<String, Number> mealLogBarChart;

    @FXML
    private BarChart<String, Number> workoutLogBarChart;
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

        // Provide external file paths here
        loadMealLogData("data_file.dat");
        loadWorkoutLogData("exercises.dat");
    }

    // Load meal log data
    private void loadMealLogData(String filePath) {
        XYChart.Series<String, Number> mealLogSeries = new XYChart.Series<>();
        mealLogSeries.setName("Meal Log");

        try {
            Food[] foods = readDataFromFile(filePath, Food[].class);
            if (foods != null) {
                for (Food food : foods) {
                    mealLogSeries.getData().add(
                            new XYChart.Data<>(food.getFoodName(), Integer.parseInt(food.getTotalCalories()))
                    );
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.err.println("Error loading meal log data: " + e.getMessage());
        }

        mealLogBarChart.getData().add(mealLogSeries);
    }

    // Load workout log data
    private void loadWorkoutLogData(String filePath) {
        XYChart.Series<String, Number> workoutLogSeries = new XYChart.Series<>();
        workoutLogSeries.setName("Workout Log");

        try {
            Exercise[] exercises = readDataFromFile(filePath, Exercise[].class);
            if (exercises != null) {
                for (Exercise exercise : exercises) {
                    workoutLogSeries.getData().add(
                            new XYChart.Data<>(exercise.getExerciseName(), Integer.parseInt(exercise.getSetsDone()))
                    );
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.err.println("Error loading workout log data: " + e.getMessage());
        }

        workoutLogBarChart.getData().add(workoutLogSeries);
    }

    // Generic method to read serialized data from a file
    private <T> T readDataFromFile(String filePath, Class<T> type) {
        try (FileInputStream fis = new FileInputStream(new File(filePath));
             ObjectInputStream ois = new ObjectInputStream(fis)) {

            return type.cast(ois.readObject());
        } catch (Exception e) {
            e.printStackTrace();
            System.err.println("Error reading data from file: " + filePath + " - " + e.getMessage());
        }
        return null;
    }
}
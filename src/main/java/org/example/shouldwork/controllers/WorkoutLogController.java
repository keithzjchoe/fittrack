package org.example.shouldwork.controllers;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import org.example.shouldwork.dao.ProfileDAO;
import org.example.shouldwork.dao.WorkoutLogDAO;
import org.example.shouldwork.dto.Exercise;
import org.example.shouldwork.dto.ProfileDTO;

import java.io.*;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class WorkoutLogController implements Initializable {
/// ////////
@FXML
private TextField emailField;
    @FXML
    private PasswordField passwordField;

    private HelloApplication mainApp;
    private final ProfileDAO profileDAO = new ProfileDAO();
    private final WorkoutLogDAO workoutLogDAO;
    public WorkoutLogController() {
        this.workoutLogDAO = new WorkoutLogDAO();
    }

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
/// /////////
    @FXML
    private TableColumn<Exercise, String> exerciseName;

    @FXML
    private TableColumn<Exercise, String> totalRepetition;

    @FXML
    private TableColumn<Exercise, String> totalSets;

    @FXML
    private TableColumn<Exercise, String> setsDone;

    @FXML
    private TableView<Exercise> table;

    @FXML
    private TextField txtExerciseName;

    @FXML
    private TextField txtTotalRepetition;

    @FXML
    private TextField txtTotalSets;

    @FXML
    private TextField txtSetsDone;

    private final String DATA_FILE = "exercises.dat";
    @FXML
    private Label usernameField;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        // Fetch all profiles from the DAO
        List<ProfileDTO> profiles = profileDAO.getAll();

        // Assume the first profile is the one we want to display (modify this as needed)
        if (profiles.isEmpty()) {
            System.out.println("No profiles found to display.");
            return;
        }

        ProfileDTO profile = profiles.getFirst();
        usernameField.setText(profile.getUsername());
        exerciseName.setCellValueFactory(new PropertyValueFactory<>("exerciseName"));
        totalRepetition.setCellValueFactory(new PropertyValueFactory<>("totalRepetition"));
        totalSets.setCellValueFactory(new PropertyValueFactory<>("totalSets"));
        setsDone.setCellValueFactory(new PropertyValueFactory<>("setsDone"));

        // Load data from the file
        table.setItems(loadDataFromFile());

        // Enable editing
        editData();
    }

    @FXML
    private void btnAdd(ActionEvent event) {
        if (!txtExerciseName.getText().isEmpty() &&
                !txtTotalRepetition.getText().isEmpty() &&
                !txtTotalSets.getText().isEmpty() &&
                !txtSetsDone.getText().isEmpty()) {

            Exercise newExercise = new Exercise(
                    txtExerciseName.getText(),
                    txtTotalRepetition.getText(),
                    txtTotalSets.getText(),
                    txtSetsDone.getText()
            );

            table.getItems().add(newExercise);
            saveDataToFile();

            txtExerciseName.clear();
            txtTotalRepetition.clear();
            txtTotalSets.clear();
            txtSetsDone.clear();
        } else {
            System.out.println("Fields should not be empty.");
        }
    }

    @FXML
    private void btnDelete(ActionEvent event) {
        TableView.TableViewSelectionModel<Exercise> selectionModel = table.getSelectionModel();
        if (selectionModel.isEmpty()) {
            System.out.println("You need to select a data before deleting.");
            return;
        }

        ObservableList<Integer> selectedIndices = selectionModel.getSelectedIndices();
        Integer[] indices = selectedIndices.toArray(new Integer[0]);

        for (int i = indices.length - 1; i >= 0; i--) {
            table.getItems().remove((int) indices[i]);
        }

        saveDataToFile();
    }

    private void editData() {
        exerciseName.setCellFactory(TextFieldTableCell.forTableColumn());
        exerciseName.setOnEditCommit(event -> {
            Exercise exercise = event.getRowValue();
            exercise.setExerciseName(event.getNewValue());
            saveDataToFile();
        });

        totalRepetition.setCellFactory(TextFieldTableCell.forTableColumn());
        totalRepetition.setOnEditCommit(event -> {
            Exercise exercise = event.getRowValue();
            exercise.setTotalRepetition(event.getNewValue());
            saveDataToFile();
        });

        totalSets.setCellFactory(TextFieldTableCell.forTableColumn());
        totalSets.setOnEditCommit(event -> {
            Exercise exercise = event.getRowValue();
            exercise.setTotalSets(event.getNewValue());
            saveDataToFile();
        });

        setsDone.setCellFactory(TextFieldTableCell.forTableColumn());
        setsDone.setOnEditCommit(event -> {
            Exercise exercise = event.getRowValue();
            exercise.setSetsDone(event.getNewValue());
            saveDataToFile();
        });
    }

    private ObservableList<Exercise> loadDataFromFile() {
        ObservableList<Exercise> data = FXCollections.observableArrayList();
        File file = new File(DATA_FILE);

        if (file.exists()) {
            try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file))) {
                data = FXCollections.observableArrayList((Exercise[]) ois.readObject());
            } catch (IOException | ClassNotFoundException e) {
                e.printStackTrace();
            }
        }

        return data;
    }

    private void saveDataToFile() {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(DATA_FILE))) {
            oos.writeObject(table.getItems().toArray(new Exercise[0]));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

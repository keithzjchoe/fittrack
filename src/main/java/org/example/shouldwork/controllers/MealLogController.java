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
import org.example.shouldwork.dto.Food;
import org.example.shouldwork.dto.ProfileDTO;

import java.io.*;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class MealLogController implements Initializable {
    /// ////////
    @FXML
    private TextField emailField;
    @FXML
    private PasswordField passwordField;

    private HelloApplication mainApp;
    private final ProfileDAO profileDAO = new ProfileDAO();
    private final WorkoutLogDAO workoutLogDAO;
    public MealLogController() {
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
    private TableColumn<Food, String> foodName;

    @FXML
    private TableColumn<Food, String> weight;

    @FXML
    private TableColumn<Food, String> totalCalories;

    @FXML
    private TableColumn<Food, String> carbohydrates;

    @FXML
    private TableColumn<Food, String> fats;

    @FXML
    private TableColumn<Food, String> proteins;

    @FXML
    private TableView<Food> table;

    @FXML
    private TextField txtFoodName;

    @FXML
    private TextField txtWeight;

    @FXML
    private TextField txtTotalCalories;

    @FXML
    private TextField txtCarbohydrates;

    @FXML
    private TextField txtFats;

    @FXML
    private TextField txtProteins;
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

        foodName.setCellValueFactory(new PropertyValueFactory<>("foodName"));
        weight.setCellValueFactory(new PropertyValueFactory<>("weight"));
        totalCalories.setCellValueFactory(new PropertyValueFactory<>("totalCalories"));
        carbohydrates.setCellValueFactory(new PropertyValueFactory<>("carbohydrates"));
        fats.setCellValueFactory(new PropertyValueFactory<>("fats"));
        proteins.setCellValueFactory(new PropertyValueFactory<>("proteins"));

        // Load data from the file
        table.setItems(loadDataFromFile());

        // Enable editing
        editData();
    }

    @FXML
    private void btnAdd(ActionEvent event) {
        if (!txtFoodName.getText().isEmpty() &&
                !txtWeight.getText().isEmpty() &&
                !txtTotalCalories.getText().isEmpty() &&
                !txtCarbohydrates.getText().isEmpty() &&
                !txtFats.getText().isEmpty() &&
                !txtProteins.getText().isEmpty()) {

            Food newFood = new Food(
                    txtFoodName.getText(),
                    txtWeight.getText(),
                    txtTotalCalories.getText(),
                    txtCarbohydrates.getText(),
                    txtFats.getText(),
                    txtProteins.getText()
            );

            table.getItems().add(newFood);
            saveDataToFile();

            txtFoodName.clear();
            txtWeight.clear();
            txtTotalCalories.clear();
            txtCarbohydrates.clear();
            txtFats.clear();
            txtProteins.clear();
        } else {
            System.out.println("Fields should not be empty.");
        }
    }

    @FXML
    private void btnDelete(ActionEvent event) {
        TableView.TableViewSelectionModel<Food> selectionModel = table.getSelectionModel();
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
        foodName.setCellFactory(TextFieldTableCell.forTableColumn());
        foodName.setOnEditCommit(event -> {
            Food food = event.getRowValue();
            food.setFoodName(event.getNewValue());
            saveDataToFile();
        });

        weight.setCellFactory(TextFieldTableCell.forTableColumn());
        weight.setOnEditCommit(event -> {
            Food food = event.getRowValue();
            food.setWeight(event.getNewValue());
            saveDataToFile();
        });

        totalCalories.setCellFactory(TextFieldTableCell.forTableColumn());
        totalCalories.setOnEditCommit(event -> {
            Food food = event.getRowValue();
            food.setTotalCalories(event.getNewValue());
            saveDataToFile();
        });

        carbohydrates.setCellFactory(TextFieldTableCell.forTableColumn());
        carbohydrates.setOnEditCommit(event -> {
            Food food = event.getRowValue();
            food.setCarbohydrates(event.getNewValue());
            saveDataToFile();
        });

        fats.setCellFactory(TextFieldTableCell.forTableColumn());
        fats.setOnEditCommit(event -> {
            Food food = event.getRowValue();
            food.setFats(event.getNewValue());
            saveDataToFile();
        });

        proteins.setCellFactory(TextFieldTableCell.forTableColumn());
        proteins.setOnEditCommit(event -> {
            Food food = event.getRowValue();
            food.setProteins(event.getNewValue());
            saveDataToFile();
        });
    }

    private ObservableList<Food> loadDataFromFile() {
        ObservableList<Food> data = FXCollections.observableArrayList();
        File file = new File("data_file.dat");

        if (file.exists()) {
            try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file))) {
                data = FXCollections.observableArrayList((Food[]) ois.readObject());
            } catch (IOException | ClassNotFoundException e) {
                e.printStackTrace();
            }
        }

        return data;
    }

    private void saveDataToFile() {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("data_file.dat"))) {
            oos.writeObject(table.getItems().toArray(new Food[0]));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
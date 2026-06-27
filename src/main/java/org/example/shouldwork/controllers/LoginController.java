package org.example.shouldwork.controllers;

import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import org.example.shouldwork.dao.ProfileDAO;
import org.example.shouldwork.dto.ProfileDTO;
import org.example.shouldwork.dao.WorkoutLogDAO;
import org.example.shouldwork.dto.WorkoutDTO;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

import java.io.File;
import java.util.Iterator;

public class  LoginController {
    @FXML
    private TextField emailField;
    @FXML
    private PasswordField passwordField;

    private HelloApplication mainApp;
    private final ProfileDAO profileDAO = new ProfileDAO();
    private final WorkoutLogDAO workoutLogDAO;
    public LoginController() {
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

    //actually log in stuff
    @FXML
    public void handleLogin() {
        String email = this.emailField.getText();
        String password = this.passwordField.getText();
        Iterator<ProfileDTO> var3 = this.profileDAO.getAll().iterator();

        ProfileDTO profile;
        do {
            if (!var3.hasNext()) {
                System.out.println("Invalid login credentials!");
                return;
            }

            profile = (ProfileDTO)var3.next();
        } while(!profile.getEmail().equals(email) || !password.equals(password));

        System.out.println("Login successful!");
        mainApp.showScene("/org/example/shouldwork/dashboard.fxml");

    }


    //registration part
    //needs to be here cause we need to use the same controller for now? but hopefully we can fix that
    @FXML
    private TextField usernameField;
    @FXML
    private PasswordField confirmPasswordField;
    @FXML
    private TextField heightField;
    @FXML
    private TextField weightField;
    @FXML
    private TextField ageField;
    @FXML
    private RadioButton maleRadioButton;
    @FXML
    private RadioButton femaleRadioButton;
    @FXML
    private ImageView profilePicture;

    @FXML
    private TextField exerciseField;
    @FXML
    private TextField setsField;
    @FXML
    private TextField repsField;
    @FXML
    private ComboBox<String> dayDropdown;
    @FXML
    private Button addRoutineButton;
    @FXML
    private Button editRoutineButton;

    //Controller Method for Register Page
    @FXML
    private void register1() throws Exception {
        String username = usernameField.getText();
        String email = emailField.getText();
        String password = passwordField.getText();
        String confirmPassword = confirmPasswordField.getText();

        if (!password.equals(confirmPassword)) {
            throw new Exception("Passwords do not match!");
        }

        ProfileDTO newProfilePart1 = new ProfileDTO("1", username, email, 0, 0, null, password );
        profileDAO.save(newProfilePart1);
        System.out.println("Basic user information saved successfully!");
        mainApp.showScene("/org/example/shouldwork/SetUp.fxml");
        //add change scene to setup too
    }


    //Controller Method for Set Up Page
    @FXML
    private void register2() throws Exception {
        try {
            // Retrieve height and weight inputs
            int height = Integer.parseInt(heightField.getText());
            int weight = Integer.parseInt(weightField.getText());
            String gender = maleRadioButton.isSelected() ? "Male" : "Female";

            // Retrieve the existing profile by its unique identifier
            ProfileDTO existingProfile = profileDAO.get("1"); // Use the same id as in register1
            if (existingProfile == null) {
                throw new Exception("Profile not found!");
            }

            // Update the profile's height, weight, and gender
            existingProfile.setHeight(height);
            existingProfile.setWeight(weight);
            existingProfile.setGender(gender);

            // Save the updated profile
            profileDAO.update(existingProfile);

            System.out.println("Additional user details saved successfully!");
            mainApp.showScene("/org/example/shouldwork/workoutLog.fxml");

        } catch (NumberFormatException e) {
            throw new Exception("Invalid input for height or weight!");
        }
    }
    // TableView and columns for displaying workout data
    @FXML
    private TableView<WorkoutDTO> workoutTable;
    @FXML
    private TableColumn<WorkoutDTO, String> exerciseColumn;
    @FXML
    private TableColumn<WorkoutDTO, Integer> setsColumn;
    @FXML
    private TableColumn<WorkoutDTO, Integer> repsColumn;
/*
    public void initialize() {
        // Initialize columns
        exerciseColumn.setCellValueFactory(new PropertyValueFactory<>("exercise"));
        setsColumn.setCellValueFactory(new PropertyValueFactory<>("sets"));
        repsColumn.setCellValueFactory(new PropertyValueFactory<>("reps"));

        // Load initial data
        loadWorkoutData();
    }

    private void loadWorkoutData() {
        // Load workout data from DAO
        List<WorkoutDTO> workoutLogs = workoutLogDAO.getAll();

        // Convert to ObservableList for JavaFX
        ObservableList<WorkoutDTO> workoutData = FXCollections.observableArrayList(workoutLogs);

        // Bind the data to the TableView
        workoutTable.setItems(workoutData);
    }

 */
/*
    public void initialize() {
        loadWorkoutData();
        if (dayDropdown == null) {
            System.out.println("dayDropdown is null. Check fx:id and FXML loading.");
        } else {
            loadDayDropdown();
        }
    }

    private void loadWorkoutData() {
        // Load workout data from DAO
        List<WorkoutDTO> workoutLogs = workoutLogDAO.getAll();
        // Display the workout data
    }

 */

    private void loadDayDropdown() {
        //  Dropdown Tab for Days
        dayDropdown.getItems().addAll("Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday");
    }


    //maybe make one controller that checks whether workoutLogs.dat has been created. If it has, use update. If no, use add?

    @FXML
    private void handleRoutine() throws Exception {
        // Path to the file (adjust the path as per your application's structure)
        File workoutFile = new File("workoutLogs.dat");

        if (workoutFile.exists()) {
            System.out.println("File exists. Updating routine...");
            updateRoutine();
        } else {
            System.out.println("File does not exist. Adding new routine...");
            addRoutine();
        }
    }

    //Add Routine Controller
    //rn this only works for creation of file and will overwrite anything in the file with the newest info
    @FXML
    private void addRoutine() throws Exception {
        try {
            String exercise = exerciseField.getText();
            int sets = Integer.parseInt(setsField.getText());
            int reps = Integer.parseInt(repsField.getText());

            WorkoutDTO newRoutine = new WorkoutDTO(exercise, sets, reps);  // 0 progress for a new routine
            workoutLogDAO.save(newRoutine);
            System.out.println("User details saved successfully!");

        } catch (NumberFormatException e) {
            throw new Exception("Invalid input for height or weight!");
        }

    }

    @FXML
    private void updateRoutine() throws Exception {
        try {

            String exercise = exerciseField.getText();
            int sets = Integer.parseInt(setsField.getText());
            int reps = Integer.parseInt(repsField.getText());

            WorkoutDTO newRoutine = new WorkoutDTO(exercise, sets, reps);  // 0 progress for a new routine
            workoutLogDAO.update(newRoutine);
            System.out.println("User details saved successfully!");
        } catch (NumberFormatException e) {
            throw new Exception("Invalid input for height or weight!");
        }
    }


/*
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
*/


}

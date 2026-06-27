# FitTrack - Fitness Tracking Desktop Application

A JavaFX desktop application for tracking workouts, meals, and fitness goals. Built as a group project with a full MVC architecture, persistent file storage, and a multi-screen UI.

---

## Project Overview

FitTrack is a standalone fitness management application that allows users to create a profile, log workouts and meals, set caloric intake goals, and view a data overview of their fitness activity without requiring an internet connection or external database.

---

## Features

- **User Authentication** : Sign up, log in, and set up a personal profile
- **Dashboard** : Personalised home screen displaying username, fitness goal, and calorie summary
- **Workout Log** : Add, edit, and delete exercises with sets and repetitions tracking
- **Meal Log** : Log food items and track daily caloric intake against a set goal
- **Data Overview** : Summary view of logged fitness and meal data
- **Profile Management** : View and update personal details (username, email, height, weight, gender)
- **Persistent Storage** : All data is saved locally to `.dat` files and reloaded on next launch

---

## Tech Stack

- Java (JavaFX)
- JavaFX FXML + SceneBuilder (UI layout)
- Java Serialization (file-based data persistence)
- Maven (build and dependency management)

---

## Architecture

The project follows a layered **MVC (Model-View-Controller)** pattern with a DAO (Data Access Object) layer for data management:

```
src/
├── controllers/       # JavaFX controllers — handle UI logic and screen navigation
├── dao/               # Data Access Objects — read/write data to .dat files
├── dto/               # Data Transfer Objects — carry data between layers
├── model/             # Core data models (Profile, WorkoutLog, MealLog, etc.)
├── utils/             # Utility classes (FileUtils)
└── resources/
    ├── *.fxml         # UI layout files (SceneBuilder)
    └── Images/        # UI icons and assets
```

---

## My Contributions

This was a group project (4 members). I served as the **Backend Engineer**, responsible for:

- Designing and implementing the **DAO layer** for all data access (Profile, Workout, Meal, Data Overview)
- Building the **DTO and Model classes** for data encapsulation and transfer between layers
- Implementing all **JavaFX Controllers**, wiring UI components to backend logic
- Setting up **file-based persistence** using Java Object Serialization (`ObjectInputStream` / `ObjectOutputStream`)
- Structuring the overall **MVC architecture** of the project

---

## How to Run

### Prerequisites
- Java 17 or higher
- Maven

### Steps
```bash
# Clone the repository
git clone https://github.com/keithzjchoe/fittrack.git
cd fittrack

# Build and run with Maven
./mvnw javafx:run
```

> **Note:** On Windows, use `mvnw.cmd javafx:run` instead.

---

## Screenshots

*(Coming soon)*

---

## Acknowledgements

Group project : Taylor's University, Bachelor of Computer Science.  
Backend architecture and implementation by Keith Choe.

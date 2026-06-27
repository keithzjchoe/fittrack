package org.example.shouldwork.model;

public class WorkoutLog {
    private int id;
    private String routineName;
    private int sets;
    private int reps;

    // Constructor, Getters, Setters

    public WorkoutLog(int id, String routineName, int sets, int reps) {
        this.id = id;
        this.routineName = routineName;
        this.sets = sets;
        this.reps = reps;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getRoutineName() {
        return routineName;
    }

    public void setRoutineName(String routineName) {
        this.routineName = routineName;
    }

    public int getSets() {
        return sets;
    }

    public void setSets(int sets) {
        this.sets = sets;
    }

    public int getReps() {
        return reps;
    }

    public void setReps(int reps) {
        this.reps = reps;
    }
}



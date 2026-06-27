package org.example.shouldwork.dto;

import java.io.Serializable;

public class WorkoutDTO implements Serializable {
    private int id;
    private String routineName;
    private int sets;
    private int reps;

    // Constructor, Getters, Setters, and toString


    public WorkoutDTO(String routineName, int sets, int reps) {
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

    @Override
    public String toString() {
        return "WorkoutDTO{" +
                ", routineName='" + routineName + '\'' +
                ", sets=" + sets +
                ", reps=" + reps +
                '}';
    }
}



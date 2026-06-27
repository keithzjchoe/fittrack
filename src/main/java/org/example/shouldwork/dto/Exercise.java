package org.example.shouldwork.dto;

import java.io.Serializable;

public class Exercise implements Serializable {
    private static final long serialVersionUID = 1L; // Added for serialization consistency

    private String exerciseName;
    private String totalRepetition;
    private String totalSets;
    private String setsDone;

    public Exercise(String exerciseName, String totalRepetition, String totalSets, String setsDone) {
        this.exerciseName = exerciseName;
        this.totalRepetition = totalRepetition;
        this.totalSets = totalSets;
        this.setsDone = setsDone;
    }

    public String getExerciseName() {
        return exerciseName;
    }

    public void setExerciseName(String exerciseName) {
        this.exerciseName = exerciseName;
    }

    public String getTotalRepetition() {
        return totalRepetition;
    }

    public void setTotalRepetition(String totalRepetition) {
        this.totalRepetition = totalRepetition;
    }

    public String getTotalSets() {
        return totalSets;
    }

    public void setTotalSets(String totalSets) {
        this.totalSets = totalSets;
    }

    public String getSetsDone() {
        return setsDone;
    }

    public void setSetsDone(String setsDone) {
        this.setsDone = setsDone;
    }
}

package org.example.shouldwork.model;

public class DataOverview {
    private double totalCalories;
    private double totalDuration;

    public DataOverview() {
        this.totalCalories = 0;
        this.totalDuration = 0;
    }

    public double getTotalCalories() {
        return totalCalories;
    }

    public double getTotalDuration() {
        return totalDuration;
    }
/*
    public void addMealLog(MealLog meal) {
        totalCalories += meal.getCalories();
    }

    public void addWorkoutLog(Workout workout) {
        totalDuration += workout.getDuration();
    }
*/
    public void resetData() {
        totalCalories = 0;
        totalDuration = 0;
    }

    @Override
    public String toString() {
        return "DataOverview{" +
                "totalCalories=" + totalCalories +
                ", totalDuration=" + totalDuration +
                '}';
    }
}


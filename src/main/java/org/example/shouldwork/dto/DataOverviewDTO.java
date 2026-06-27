package org.example.shouldwork.dto;

import java.io.Serializable;

public class DataOverviewDTO implements Serializable {
    private int id;
    private int day;
    private int caloriesConsumed;
    private int caloriesGoal;

    // Constructor, Getters, Setters, and toString


    public int getId(){
        return id;
    }

    public void setId(int id){
        this.id = id;
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }

    public int getCaloriesConsumed() {
        return caloriesConsumed;
    }

    public void setCaloriesConsumed(int caloriesConsumed) {
        this.caloriesConsumed = caloriesConsumed;
    }

    public int getCaloriesGoal() {
        return caloriesGoal;
    }

    public void setCaloriesGoal(int caloriesGoal) {
        this.caloriesGoal = caloriesGoal;
    }

    public DataOverviewDTO(int day, int caloriesConsumed, int caloriesGoal, int id) {
        this.day = day;
        this.caloriesConsumed = caloriesConsumed;
        this.caloriesGoal = caloriesGoal;



    }

    @Override
    public String toString() {
        return "DataOverviewDTO{" +
                "day=" + day +
                ", caloriesConsumed=" + caloriesConsumed +
                ", caloriesGoal=" + caloriesGoal +
                ", id=" + id +
                '}';
    }
}



package org.example.shouldwork.dto;

import java.io.Serializable;

public class Food implements Serializable {
    private String carbohydrates;
    private String fats;
    private String foodName;
    private String proteins;
    private String totalCalories;
    private String weight; // in grams

    public Food(String foodName, String weight, String totalCalories, String carbohydrates, String fats, String proteins) {
        this.foodName = foodName;
        this.weight = weight;
        this.totalCalories = totalCalories;
        this.carbohydrates = carbohydrates;
        this.fats = fats;
        this.proteins = proteins;
    }

    public String getFoodName() {
        return foodName;
    }

    public void setFoodName(String foodName) {
        this.foodName = foodName;
    }

    public String getWeight() {
        return weight;
    }

    public void setWeight(String weight) {
        this.weight = weight;
    }

    public String getTotalCalories() {
        return totalCalories;
    }

    public void setTotalCalories(String totalCalories) {
        this.totalCalories = totalCalories;
    }

    public String getCarbohydrates() {
        return carbohydrates;
    }

    public void setCarbohydrates(String carbohydrates) {
        this.carbohydrates = carbohydrates;
    }

    public String getFats() {
        return fats;
    }

    public void setFats(String fats) {
        this.fats = fats;
    }

    public String getProteins() {
        return proteins;
    }

    public void setProteins(String proteins) {
        this.proteins = proteins;
    }
}

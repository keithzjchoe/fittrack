package org.example.shouldwork.model;

public class MealLog {
    private int id;
    private String foodName;
    private double weight;
    private int totalKcal;
    private int carbs;
    private int fats;
    private int proteins;

    // Constructor, Getters, Setters


    public MealLog(int id, String foodName, double weight, int totalKcal, int carbs, int fats, int proteins) {
        this.id = id;
        this.foodName = foodName;
        this.weight = weight;
        this.totalKcal = totalKcal;
        this.carbs = carbs;
        this.fats = fats;
        this.proteins = proteins;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFoodName() {
        return foodName;
    }

    public void setFoodName(String foodName) {
        this.foodName = foodName;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public int getTotalKcal() {
        return totalKcal;
    }

    public void setTotalKcal(int totalKcal) {
        this.totalKcal = totalKcal;
    }

    public int getCarbs() {
        return carbs;
    }

    public void setCarbs(int carbs) {
        this.carbs = carbs;
    }

    public int getFats() {
        return fats;
    }

    public void setFats(int fats) {
        this.fats = fats;
    }

    public int getProteins() {
        return proteins;
    }

    public void setProteins(int proteins) {
        this.proteins = proteins;
    }
}






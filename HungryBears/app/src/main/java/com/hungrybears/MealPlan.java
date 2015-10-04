package com.hungrybears;

/**
 * Created by vivian on 10/3/15.
 */
public class MealPlan {
    public static double getPointsFromPlan(String meal_plan){
        double meal_points = 0.0;
        switch (meal_plan) {
            case "Other" :
                //ge from field
                break;
            case "Standard":
                meal_points = 1250.0;
                break;
            case "Premium":
                meal_points = 1500.0;
                break;
            case "Ultimate Access":
                meal_points = 250.0;
                break;
            case "Non-Resident: Blue":
                meal_points = 600.0;
                break;
            case "Non-Resident: Gold":
                meal_points = 875.0;
                break;
            case "Non-Resident: Platinum":
                meal_points = 1150.0;
                break;
        }
        return meal_points;
    }
}

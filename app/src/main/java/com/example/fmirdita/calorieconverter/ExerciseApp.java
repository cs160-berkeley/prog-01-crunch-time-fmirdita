package com.example.fmirdita.calorieconverter;

import java.util.HashMap;

/**
 * Created by fmirdita on 2/2/16.
 */
public class ExerciseApp extends android.app.Application {

    public HashMap<String,Double> getRepConversions() {
        HashMap<String,Double> conversions = new HashMap<String,Double>();
        conversions.put("Pushups", 0.286);
        conversions.put("Situps", 0.5);
        conversions.put("Squats", 0.445);
        conversions.put("Pullups", 1.0);
        return conversions;
    }

    public HashMap<String,Double> getTimeConversions() {
        HashMap<String,Double> conversions = new HashMap<String,Double>();
        conversions.put("Jumping Jacks", 10.0);
        conversions.put("Jogging", 8.33);
        conversions.put("Leg-lifts", 4.0);
        conversions.put("Plank", 4.0);
        conversions.put("Cycling", 8.34);
        conversions.put("Walking", 5.0);
        conversions.put("Swimming", 7.7);
        conversions.put("Stair-Climbing", 6.667);
        return conversions;
    }

}

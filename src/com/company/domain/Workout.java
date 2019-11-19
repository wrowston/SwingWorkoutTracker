package com.company.domain;

import java.util.HashMap;
import java.util.Map;

public class Workout {
    private Map<String, ExerciseList> workout;
    private String date;

    public Workout(String date) {
        this.date = date;
        this.workout = new HashMap<>();
    }

    public void addWorkout(String date, ExerciseList exerciseList) {
        this.workout.put(date, exerciseList);
    }

    public Map<String, ExerciseList> getWorkout() {
        return this.workout;
    }

    public String getDate() {
        return this.date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getDates() {
        String date = "";
        for (String key : this.workout.keySet()) {
            date = key;
        }
        return date;
    }


}

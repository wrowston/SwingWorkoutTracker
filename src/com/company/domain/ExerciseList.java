package com.company.domain;

import java.util.ArrayList;
import java.util.List;

public class ExerciseList {
    private List<String> exerciseList;

    public ExerciseList() {
        this.exerciseList = new ArrayList<>();
    }

    public void addExercise(String exercise) {
        this.exerciseList.add(exercise);
    }

//    public List<String> getExerciseList() {
//        return this.exerciseList;
//    }

    @Override
    public String toString() {
        String e = "";
        for (String exercise : this.exerciseList) {
            e = exercise;
        }
        return e;
    }
}

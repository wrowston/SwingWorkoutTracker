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

    public List<String> getExerciseList() {
        return this.exerciseList;
    }

    @Override
    public String toString() {
        StringBuilder e = new StringBuilder();
        for (String exercise : this.exerciseList) {
            e.append(exercise).append(" \n");
        }
        return e.toString();
    }
}

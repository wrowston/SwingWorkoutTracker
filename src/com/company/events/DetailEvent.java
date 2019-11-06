package com.company.events;

import java.util.EventObject;

public class DetailEvent extends EventObject {

    private String exerciseText;

    public DetailEvent(Object source, String exerciseText) {
        super(source);

        this.exerciseText = exerciseText;
    }

    public String getExerciseText(){
        return this.exerciseText;
    }
}

package com.company.gui;

import javax.swing.*;

public class UserInterface implements Runnable {

    private JFrame frame;
    private JButton newWorkoutButton;
    private JButton searchButton;
    private JButton addExerciseButton;
    private JButton saveWorkoutButton;


    @Override
    public void run() {

    }

    public void setVariableNames() {
        this.newWorkoutButton = new JButton("Create New Workout");
        this.searchButton = new JButton("Search Completed Workouts");
        this.addExerciseButton = new JButton("Add Exercise");
        this.saveWorkoutButton = new JButton("Save Workout");

    }
}

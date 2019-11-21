package com.company.gui.frames;

/*
Opening frame that gives you an option to start a new workout or search previous workouts
 */

import com.company.gui.buttonlisteners.MainFrameButtonListener;

import javax.swing.*;
import java.awt.*;

public class MainFrame extends JFrame {
    private JButton newWorkoutButton;
    private JButton searchButton;

    public MainFrame(String title) {
        super(title);
        createComponents(getContentPane());
    }

    public void createComponents(Container c) {
        this.newWorkoutButton = new JButton("Create New Workout");
        this.searchButton = new JButton("Search Completed Workouts");

        buttonBehavior();
        setLayout(new BorderLayout());

        c.add(newWorkoutButton, BorderLayout.NORTH);
        c.add(searchButton, BorderLayout.SOUTH);
    }

    public void buttonBehavior() {
        MainFrameButtonListener listener = new MainFrameButtonListener(newWorkoutButton, searchButton);
        newWorkoutButton.addActionListener(listener);
        searchButton.addActionListener(listener);
    }
}

package com.company.gui.buttonlisteners;

import com.company.gui.frames.SearchFrame;
import com.company.gui.frames.WorkoutFrame;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainFrameButtonListener implements ActionListener {
    private JButton newWorkoutButton;
    private JButton searchButton;

    public MainFrameButtonListener(JButton newWorkoutButton, JButton searchButton) {
        this.newWorkoutButton = newWorkoutButton;
        this.searchButton = searchButton;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == this.newWorkoutButton) {
            JFrame newWorkoutFrame = new WorkoutFrame("New Workout");
            newWorkoutFrame.setSize(800,550);
            newWorkoutFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            newWorkoutFrame.setVisible(true);

        } else if (e.getSource() == this.searchButton) {
            JFrame searchFrame = new SearchFrame("Search Workouts");
            searchFrame.setSize(900, 400);
            searchFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            searchFrame.setVisible(true);
        }
    }
}

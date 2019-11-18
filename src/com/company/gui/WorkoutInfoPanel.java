package com.company.gui;

import javax.swing.*;
import java.awt.*;


/*
This class creates a panel that is supposed to hold the date of the workout
***Dates make each workout unique***

should hold exercise data too
 */
public class WorkoutInfoPanel extends JPanel {

    private JTextArea workoutTextArea;

    public WorkoutInfoPanel() {
        Dimension size = getPreferredSize();
        size.width = 400;
        setPreferredSize(size);

        setBorder(BorderFactory.createTitledBorder("Workout Information"));

        workoutTextArea = new JTextArea();

        setLayout(new GridBagLayout());

        GridBagConstraints gc = new GridBagConstraints();

        gc.anchor = GridBagConstraints.LINE_END;
        gc.weightx = 0.5;
        gc.weighty = 0.5;

        gc.gridx = 0;
        gc.gridy = 0;
        add(this.workoutTextArea, gc);

    }

    public void addDateText(String dateText) {

        this.workoutTextArea.append(dateText);
    }

    public void addExercise(String exerciseText) {

        this.workoutTextArea.append(exerciseText);
    }
}

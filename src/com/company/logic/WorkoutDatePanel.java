package com.company.logic;

/*
this panel allows the user to enter the date of the newly created workout

Date makes each workout unique and searchable
 */

import com.company.domain.Workout;

import javax.swing.*;
import javax.swing.event.EventListenerList;
import java.awt.*;
import java.io.Serializable;

public class WorkoutDatePanel extends JPanel implements Serializable {

    private static final long serialVersionUID = 1829291638760837942L;

    private EventListenerList listenerList = new EventListenerList();
    private Workout workout;

    public WorkoutDatePanel() {
        Dimension size = getPreferredSize();
        size.width = 400;
        size.height = 75;
        setPreferredSize(size);

        JLabel dateLabel = new JLabel("Today's Date (mm/dd/yy): ");
        final JTextField dateText = new JTextField(10);
        this.workout = new Workout(dateText.getText());

        setLayout(new GridBagLayout());

        GridBagConstraints gc = new GridBagConstraints();

        //first column
        gc.anchor = GridBagConstraints.LINE_END;
        gc.weightx = 0.5;
        gc.weighty = 0.5;

        gc.gridx = 0;
        gc.gridy = 1;
        add(dateLabel, gc);


        //second column
        gc.anchor = GridBagConstraints.LINE_START;
        gc.gridx = 1;
        gc.gridy = 1;
        add(dateText, gc);

    }

    public Workout getWorkout() {
        return this.workout;
    }
}

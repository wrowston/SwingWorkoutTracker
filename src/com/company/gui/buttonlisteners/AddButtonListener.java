package com.company.gui.buttonlisteners;

import com.company.domain.ExerciseList;
import com.company.events.DetailEvent;
import com.company.gui.EventHandling;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


/*
class to give the add button functionality

having trouble printing exercises onto text area in main frame
    -issue might be with fireDetailEvent() method or addDetailListener() method
 */

public class AddButtonListener implements ActionListener {
    private JButton addExercise;
    private JTextField exerciseType;
    private JTextField sets;
    private JTextField reps;
    private JTextField weight;
    private ExerciseList exerciseList;
    private JPanel panel;

    private EventHandling eventHandling;
    private String exerciseText;

    public AddButtonListener(JButton addExercise, JTextField exerciseType, JTextField sets, JTextField reps,
                             JTextField weight, ExerciseList exerciseList, JPanel panel) {
        this.addExercise = addExercise;
        this.exerciseType = exerciseType;
        this.sets = sets;
        this.reps = reps;
        this.weight = weight;
        this.exerciseList = exerciseList;
        this.panel = panel;

        this.eventHandling = new EventHandling();
        this.exerciseText = "";
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == this.addExercise) {

            String exerciseType = this.exerciseType.getText();
            String sets = this.sets.getText();
            String reps = this.reps.getText();
            String weight = this.weight.getText();

            this.exerciseText = "Exercise Type: " + exerciseType + " | " +
                    sets + " sets | " + reps + " reps | " + weight + " pounds\n";

            this.exerciseList.addExercise(exerciseText);

            eventHandling.fireDetailEvent(new DetailEvent(panel, exerciseText));

            this.exerciseType.setText("");
            this.sets.setText("");
            this.reps.setText("");
            this.weight.setText("");
        }
    }

    public String getExerciseText() {
        return exerciseText;
    }

    public EventHandling getEventHandling() {
        return eventHandling;
    }
}

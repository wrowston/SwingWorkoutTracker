package com.company.gui.frames;

import com.company.events.DetailEvent;
import com.company.events.DetailListener;
import com.company.gui.buttonlisteners.AddButtonListener;
import com.company.gui.buttonlisteners.SaveButtonListener;
import com.company.gui.panels.ExerciseDetailsPanel;
import com.company.gui.panels.WorkoutDatePanel;

import javax.swing.*;
import java.awt.*;

public class WorkoutFrame extends JFrame {

    private ExerciseDetailsPanel exerciseDetailsPanel;
    private WorkoutDatePanel workoutDatePanel;
    private JButton saveWorkoutButton;
    private JTextArea textArea;

    public WorkoutFrame(String title) {
        super(title);
        createComponents(getContentPane());
    }

    public void createComponents(Container c) {
        this.exerciseDetailsPanel = new ExerciseDetailsPanel();
        this.workoutDatePanel = new WorkoutDatePanel();
        this.textArea = new JTextArea();
        this.saveWorkoutButton = new JButton("Save Workout");

        buttonBehavior();
        setLayout(new BorderLayout());

        c.add(this.workoutDatePanel, BorderLayout.NORTH);
        c.add(this.exerciseDetailsPanel, BorderLayout.WEST);
        c.add(this.textArea, BorderLayout.EAST);
        c.add(this.saveWorkoutButton, BorderLayout.SOUTH);
    }

    public void buttonBehavior() {

        AddButtonListener addButtonListener = new AddButtonListener(this.exerciseDetailsPanel.getAddExerciseButton(),
                exerciseDetailsPanel.getExerciseText(), exerciseDetailsPanel.getSetsText(),
                exerciseDetailsPanel.getRepsText(), exerciseDetailsPanel.getWeightText(),
                exerciseDetailsPanel.getExerciseListClass(), exerciseDetailsPanel);

        this.exerciseDetailsPanel.getAddExerciseButton().addActionListener(addButtonListener);

        addButtonListener.getEventHandling().addDetailListener(new DetailListener(){
            public void detailEventOccurred(DetailEvent event){
                String exerciseText = event.getDetailText();
                textArea.append(exerciseText);
            }
        });

        SaveButtonListener listener = new SaveButtonListener(saveWorkoutButton, this.workoutDatePanel.getDateText(),
                this.exerciseDetailsPanel.getExerciseListClass(), this);
        this.saveWorkoutButton.addActionListener(listener);
    }
}

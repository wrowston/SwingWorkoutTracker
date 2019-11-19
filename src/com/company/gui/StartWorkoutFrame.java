package com.company.gui;

import com.company.database.Mongo;
import com.company.events.DetailEvent;
import com.company.events.DetailListener;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class StartWorkoutFrame extends JFrame {

    private ExerciseDetailsPanel exerciseDetailsPanel;
    private final WorkoutDatePanel workoutDatePanel;

    public StartWorkoutFrame(String title) {
        super(title);

        setLayout(new BorderLayout());

        JButton saveWorkoutButton = new JButton("Save Workout");

        this.exerciseDetailsPanel = new ExerciseDetailsPanel();
        this.workoutDatePanel = new WorkoutDatePanel();
        final JTextArea textArea = new JTextArea();

        this.exerciseDetailsPanel.addDetailListener(new DetailListener(){
            public void detailEventOccurred(DetailEvent event){
                String exerciseText = event.getDetailText();
                textArea.append(exerciseText);
            }
        });

        saveWorkoutButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String dateText = printDate();
                saveWorkout(dateText);
                dispose();
            }
        });

        Container c = getContentPane();

        c.add(this.workoutDatePanel, BorderLayout.NORTH);
        c.add(this.exerciseDetailsPanel, BorderLayout.WEST);
        c.add(textArea, BorderLayout.EAST);
        c.add(saveWorkoutButton, BorderLayout.SOUTH);
    }


    public String printDate() {
        return this.workoutDatePanel.getDateText().getText();
    }

    public void saveWorkout(String date) {
        Mongo mongo = new Mongo();
        mongo.addToDatabase(date, this.exerciseDetailsPanel.getExerciseListClass());
    }
}

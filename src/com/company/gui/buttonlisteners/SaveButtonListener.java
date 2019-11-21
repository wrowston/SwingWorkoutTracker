package com.company.gui.buttonlisteners;

import com.company.database.Mongo;
import com.company.domain.ExerciseList;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SaveButtonListener implements ActionListener {

    private JButton saveButton;
    private JTextField date;
    private ExerciseList exerciseList;
    private JFrame frame;

    public SaveButtonListener(JButton saveButton, JTextField date, ExerciseList exerciseList, JFrame frame) {
        this.saveButton = saveButton;
        this.date = date;
        this.exerciseList = exerciseList;
        this.frame = frame;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == this.saveButton) {
            String dateText = this.date.getText();
            saveWorkout(dateText);
            this.frame.dispose();
        }
    }

    public void saveWorkout(String date) {
        Mongo mongo = new Mongo();
        mongo.addToDatabase(date, this.exerciseList);
    }
}

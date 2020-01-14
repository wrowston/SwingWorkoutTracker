package com.company.gui.panels;

/*
this panel asks the user details about the exercise and allows the user to add each exercise to the workout
Details include:
    -exercise type
    -sets
    -reps
    -weight
 */

import com.company.domain.ExerciseList;

import javax.swing.*;
import java.awt.*;

public class ExerciseDetailsPanel extends JPanel {

    private ExerciseList exerciseList = new ExerciseList();
    private JButton addExerciseButton;
    private JTextField exerciseText;
    private JTextField setsText;
    private JTextField repsText;
    private JTextField weightText;
    private JTextField notesText;

    public ExerciseDetailsPanel(){
        Dimension size = getPreferredSize();
        size.width = 400;
        setPreferredSize(size);

        setBorder(BorderFactory.createTitledBorder("New Exercise"));

        JLabel exerciseLabel = new JLabel("Exercise Type: ");
        JLabel setsLabel = new JLabel("Sets: ");
        JLabel repsLabel = new JLabel("Reps: ");
        JLabel weightLabel = new JLabel("Weight: ");
        JLabel notesLabel = new JLabel("Notes: ");

        this.exerciseText = new JTextField(10);
        this.setsText = new JTextField(10);
        this.repsText = new JTextField(10);
        this.weightText = new JTextField(10);
        this.notesText = new JTextField(10);

        setLayout(new GridBagLayout());

        GridBagConstraints gc = new GridBagConstraints();

        gc.anchor = GridBagConstraints.LINE_END;
        gc.weightx = 0.5;
        gc.weighty = 0.5;

        /////First column
        gc.gridx = 0;
        gc.gridy = 1;
        add(exerciseLabel, gc);

        gc.gridy = 2;
        add(setsLabel, gc);

        gc.gridy = 3;
        add(repsLabel, gc);

        gc.gridy = 4;
        add(weightLabel, gc);

        gc.gridy = 5;
        add(notesLabel, gc);


        /////Second Column
        gc.anchor = GridBagConstraints.LINE_START;
        gc.gridx = 1;
        gc.gridy = 1;
        add(exerciseText, gc);

        gc.gridy = 2;
        add(setsText, gc);

        gc.gridy = 3;
        add(repsText, gc);

        gc.gridy = 4;
        add(weightText, gc);

        gc.gridy = 5;
        add(notesText, gc);

        ///Final row

        this.addExerciseButton = new JButton("Add Exercise");

        gc.gridx = 1;
        gc.gridy = 6;
        add(addExerciseButton, gc);

    }

    public JButton getAddExerciseButton() {
        return addExerciseButton;
    }

    public JTextField getExerciseText() {
        return exerciseText;
    }

    public JTextField getSetsText() {
        return setsText;
    }

    public JTextField getRepsText() {
        return repsText;
    }

    public JTextField getWeightText() {
        return weightText;
    }

    public JTextField getNotesText() {
        return notesText;
    }

    public ExerciseList getExerciseListClass() {
        return this.exerciseList;
    }

}

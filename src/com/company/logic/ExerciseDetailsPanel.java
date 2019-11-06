package com.company.logic;

/*
this panel asks the user details about the exercise and allows the user to add each exercise to the workout
Details include:
    -exercise type
    -sets
    -reps
    -weight
 */

import com.company.events.DetailEvent;
import com.company.events.DetailListener;
import com.company.domain.ExerciseList;

import javax.swing.*;
import javax.swing.event.EventListenerList;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.Serializable;

public class ExerciseDetailsPanel extends JPanel implements Serializable {

    private static final long serialVersionUID = -1326984071017916448L;

    private EventListenerList listenerList = new EventListenerList();
    private ExerciseList exerciseList = new ExerciseList();

    public ExerciseDetailsPanel(){
        Dimension size = getPreferredSize();
        size.width = 400;
        setPreferredSize(size);

        setBorder(BorderFactory.createTitledBorder("New Exercise"));

        JLabel exerciseLabel = new JLabel("Exercise Type: ");
        JLabel setsLabel = new JLabel("Sets: ");
        JLabel repsLabel = new JLabel("Reps: ");
        JLabel weightLabel = new JLabel("Weight: ");

        final JTextField exerciseText = new JTextField(10);
        final JTextField setsText = new JTextField(10);
        final JTextField repsText = new JTextField(10);
        final JTextField weightText = new JTextField(10);

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

        ///Final row

        JButton addExerciseButton = new JButton("Add Exercise");

        gc.gridx = 1;
        gc.gridy = 5;
        add(addExerciseButton, gc);


        addExerciseButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                String exerciseType = exerciseText.getText();
                String sets = setsText.getText();
                String reps = repsText.getText();
                String weight = weightText.getText();

                String printExercise = "Exercise Type: " + exerciseType + " | " +
                        sets + " sets | " + reps + " reps | " + weight + " pounds\n";

                addToExerciseList(printExercise);

                fireDetailEvent(new DetailEvent(this, printExercise));

                //clear text fields
                exerciseText.setText("");
                setsText.setText("");
                repsText.setText("");
                weightText.setText("");
            }
        });
    }

    public void addToExerciseList(String exercise) {
        this.exerciseList.addExercise(exercise);
    }

    //might need to return an arraylist? test later
    public ExerciseList getExerciseList() {
        return this.exerciseList;
    }

    public void fireDetailEvent(DetailEvent event){
        Object[] listeners = listenerList.getListenerList();

        for (int i = 0; i < listeners.length; i += 2) {
            if(listeners[i] == DetailListener.class) {
                ((DetailListener)listeners[i + 1]).detailEventOccurred(event);
            }
        }
    }


    public void addDetailListener(DetailListener listener) {
        listenerList.add(DetailListener.class, listener);
    }

    public void removeDetailListener(DetailListener listener) {
        listenerList.remove(DetailListener.class, listener);
    }
}

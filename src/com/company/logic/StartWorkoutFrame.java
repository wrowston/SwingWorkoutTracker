package com.company.logic;

import com.company.domain.Workout;
import com.company.events.DetailEvent;
import com.company.events.DetailListener;

//
//import com.mongodb.MongoClient;
//import com.mongodb.MongoClientURI;
//import com.mongodb.client.MongoCollection;
//import com.mongodb.client.MongoDatabase;
//import org.bson.Document;
//import org.bson.conversions.Bson;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class StartWorkoutFrame extends JFrame {

    private ExerciseDetailsPanel exerciseDetailsPanel;
    private WorkoutDatePanel workoutDatePanel;
    //private final JScrollPane scrollPane;
    private Workout workout;

    public StartWorkoutFrame(String title) {
        super(title);

        setLayout(new BorderLayout());

        //adds workout to datebase (datebase not yet created)
        JButton saveWorkoutButton = new JButton("Save Workout");

        this.exerciseDetailsPanel = new ExerciseDetailsPanel();
        this.workoutDatePanel = new WorkoutDatePanel();

        //this.scrollPane = new JScrollPane();
        final JTextArea textArea = new JTextArea();
        //this.scrollPane.setViewportView(textArea);


        this.exerciseDetailsPanel.addDetailListener(new DetailListener(){
            public void detailEventOccurred(DetailEvent event){
                String exerciseText = event.getExerciseText();

                textArea.append(exerciseText);
            }
        });

        saveWorkoutButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //store data as a hashmap where (key = workout date, value = exerciseList)

                saveWorkout();
                dispose();
                //add workout to database
            }
        });

        Container c = getContentPane();

        c.add(this.workoutDatePanel, BorderLayout.NORTH);
        c.add(this.exerciseDetailsPanel, BorderLayout.WEST);
        c.add(textArea, BorderLayout.EAST);
        c.add(saveWorkoutButton, BorderLayout.SOUTH);
    }

    public void saveWorkout() {
        this.workout = this.workoutDatePanel.getWorkout();
        this.workout.addWorkout(this.exerciseDetailsPanel.getExerciseList());

        String uri = "mongodb+srv://Rowston:<NfB2014!>@cluster0-m0ohq.mongodb.net/test";
//        MongoClientURI clientURI = new MongoClientURI(uri);
//        MongoClient mongoClient = new MongoClient(clientURI);

    }
}

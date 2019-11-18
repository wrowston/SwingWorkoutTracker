package com.company.gui;

import com.company.domain.Workout;
import com.company.events.DetailEvent;
import com.company.events.DetailListener;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class StartWorkoutFrame extends JFrame {

    private ExerciseDetailsPanel exerciseDetailsPanel;
    private WorkoutDatePanel workoutDatePanel;
    private Workout workout;

    public StartWorkoutFrame(String title) {
        super(title);

        setLayout(new BorderLayout());

        JButton saveWorkoutButton = new JButton("Save Workout");

        this.exerciseDetailsPanel = new ExerciseDetailsPanel();
        this.workoutDatePanel = new WorkoutDatePanel();

        final JTextArea textArea = new JTextArea();

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
        //add the date and exercise lists to database
        this.workout = this.workoutDatePanel.getWorkout();
        this.workoutDatePanel.getWorkout().getDate();
        this.workout.addWorkout(this.exerciseDetailsPanel.getExerciseList());


        String uri = "mongodb+srv://Rowston:<NfB2014!>@cluster0-mgb11.mongodb.net/test";
        MongoClientURI clientURI = new MongoClientURI(uri);
        MongoClient mongoClient = new MongoClient(clientURI);

        MongoDatabase mongoDatabase = mongoClient.getDatabase("WorkoutTracker");
        MongoCollection collection = mongoDatabase.getCollection("Workouts");

        //Document document = new Document("Date", )
        //make method or class that gets key and values from hashmap created by user input

    }
}

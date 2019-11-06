package com.company.logic;

/*
Opening frame that gives you an option to start a new workout or search previous workouts
 */

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainFrame extends JFrame {

    public MainFrame(String title) {
        super(title);

        //set layout manager
        setLayout(new BorderLayout());

        //create swing components
        JButton newWorkoutButton = new JButton("Create New Workout");
        JButton searchButton = new JButton("Search Completed Workouts");


        //add swing components to content pane
        Container c = getContentPane();

        c.add(newWorkoutButton, BorderLayout.NORTH);
        c.add(searchButton, BorderLayout.SOUTH);

        //add behavior
        newWorkoutButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                JFrame newWorkoutFrame = new StartWorkoutFrame("New Workout");
                newWorkoutFrame.setSize(800,550);
                newWorkoutFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                newWorkoutFrame.setVisible(true);

            }
        });

    }
}

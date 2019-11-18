package com.company.gui;

import javax.swing.*;

/*
Author: Will Rowston 09/20/2019
Project: Workout Tracker
 */

public class Main {

    public static void main(String[] args) {

        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                JFrame frame = new MainFrame("Workout Tracker");
                frame.setSize(300,100);
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setVisible(true);
            }
        });
    }
}

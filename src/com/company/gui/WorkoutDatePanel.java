package com.company.gui;

/*
this panel allows the user to enter the date of the newly created workout

Date makes each workout unique and searchable
 */

import javax.swing.*;
import java.awt.*;

public class WorkoutDatePanel extends JPanel {
    private final JTextField dateText;

    public WorkoutDatePanel() {
        Dimension size = getPreferredSize();
        size.width = 400;
        size.height = 75;
        setPreferredSize(size);

        JLabel dateLabel = new JLabel("Today's Date (mm/dd/yy): ");
        this.dateText = new JTextField(10);

        setLayout(new GridBagLayout());

        GridBagConstraints gc = new GridBagConstraints();

        //first column
        gc.anchor = GridBagConstraints.LINE_END;
        gc.weightx = 0.5;
        gc.weighty = 0.5;

        gc.gridx = 0;
        gc.gridy = 1;
        add(dateLabel, gc);


        //second column
        gc.anchor = GridBagConstraints.LINE_START;
        gc.gridx = 1;
        gc.gridy = 1;
        add(dateText, gc);

    }

    public JTextField getDateText() {
        return dateText;
    }
}

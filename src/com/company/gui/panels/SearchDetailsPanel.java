package com.company.gui.panels;

import javax.swing.*;
import java.awt.*;

public class SearchDetailsPanel extends JPanel {
    private JLabel searchLabel;
    private final JTextField searchText;
    private JButton searchButton;
    private JButton showAllButton;

    public SearchDetailsPanel() {
        Dimension size = getPreferredSize();
        size.width = 400;
        setPreferredSize(size);
        setBorder(BorderFactory.createTitledBorder("Search"));

        this.searchLabel = new JLabel("Search By Date(mm/dd/yy/): ");
        this.searchText = new JTextField(10);

        setLayout(new GridBagLayout());

        GridBagConstraints gc = new GridBagConstraints();

        gc.anchor = GridBagConstraints.LINE_END;
        gc.weightx = 0.5;
        gc.weighty = 0.5;

        gc.gridx = 0;
        gc.gridy = 1;
        add(searchLabel, gc);

        gc.gridx = 1;
        gc.gridy = 1;
        add(searchText, gc);

        this.searchButton = new JButton("Search By Date");
        gc.gridx = 1;
        gc.gridy = 2;
        add(this.searchButton, gc);

        this.showAllButton = new JButton("Show All Workouts");
        gc.gridy = 3;
        add(this.showAllButton, gc);
    }

    public JTextField getSearchText() {
        return searchText;
    }

    public JButton getSearchButton() {
        return searchButton;
    }

    public JButton getShowAllButton() {
        return showAllButton;
    }
}

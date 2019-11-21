package com.company.gui.buttonlisteners;

import com.company.database.Mongo;
import com.company.events.DetailEvent;
import com.company.gui.EventHandling;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SearchButtonListener implements ActionListener {
    private JButton searchButton;
    private JButton showAllButton;
    private JTextField searchText;
    private JPanel panel;

    private EventHandling eventHandling;

    public SearchButtonListener(JButton searchButton, JButton showAllButton, JTextField searchText, JPanel panel) {
        this.searchButton = searchButton;
        this.showAllButton = showAllButton;
        this.searchText = searchText;
        this.panel = panel;

        this.eventHandling = new EventHandling();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == this.searchButton) {
            String dateSearched = searchText.getText();
            Mongo mongo = new Mongo();
            String foundDocument = mongo.searchByDate(dateSearched);

            eventHandling.fireDetailEvent(new DetailEvent(panel, foundDocument));

        } else if (e.getSource() == this.showAllButton) {
            Mongo mongo = new Mongo();
            String documents = mongo.showAll();

            eventHandling.fireDetailEvent(new DetailEvent(panel, documents));
        }
    }

    public EventHandling getEventHandling() {
        return eventHandling;
    }
}

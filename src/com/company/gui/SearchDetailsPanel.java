package com.company.gui;

import com.company.database.Mongo;
import com.company.events.DetailEvent;
import com.company.events.DetailListener;

import javax.swing.*;
import javax.swing.event.EventListenerList;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SearchDetailsPanel extends JPanel {
    private EventListenerList listenerList = new EventListenerList();
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

        searchButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String dateSearched = searchText.getText();
                Mongo mongo = new Mongo();
                String foundDocument = mongo.searchByDate(dateSearched);

                fireDetailEvent(new DetailEvent(this, foundDocument));
            }
        });

    }

    public void fireDetailEvent(DetailEvent event){
        Object[] listeners = this.listenerList.getListenerList();

        for (int i = 0; i < listeners.length; i += 2) {
            if(listeners[i] == DetailListener.class) {
                ((DetailListener)listeners[i + 1]).detailEventOccurred(event);
            }
        }
    }

    public void addDetailListener(DetailListener listener) {
        listenerList.add(DetailListener.class, listener);
    }
}

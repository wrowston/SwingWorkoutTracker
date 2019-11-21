package com.company.gui.frames;

import com.company.events.DetailEvent;
import com.company.events.DetailListener;
import com.company.gui.buttonlisteners.SearchButtonListener;
import com.company.gui.panels.SearchDetailsPanel;

import javax.swing.*;
import java.awt.*;

public class SearchFrame extends JFrame {

    private SearchDetailsPanel searchDetailsPanel;
    private JTextArea textArea;

    public SearchFrame(String title) {
        super(title);
        createComponents(getContentPane());
    }

    public void createComponents(Container c) {
        this.searchDetailsPanel = new SearchDetailsPanel();
        this.textArea = new JTextArea();

        buttonBehavior();
        setLayout(new BorderLayout());

        c.add(this.searchDetailsPanel, BorderLayout.WEST);
        c.add(this.textArea, BorderLayout.EAST);
    }

    public void buttonBehavior() {
        SearchButtonListener listener = new SearchButtonListener(searchDetailsPanel.getSearchButton(),
                searchDetailsPanel.getShowAllButton(), searchDetailsPanel.getSearchText(), searchDetailsPanel);

        searchDetailsPanel.getSearchButton().addActionListener(listener);
        searchDetailsPanel.getShowAllButton().addActionListener(listener);

        listener.getEventHandling().addDetailListener(new DetailListener() {
            @Override
            public void detailEventOccurred(DetailEvent event) {
                String searchDate = event.getDetailText();
                textArea.append(searchDate);
            }
        });
    }
}

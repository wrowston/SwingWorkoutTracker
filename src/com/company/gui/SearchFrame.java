package com.company.gui;

import com.company.events.DetailEvent;
import com.company.events.DetailListener;

import javax.swing.*;
import java.awt.*;

public class SearchFrame extends JFrame {

    private SearchDetailsPanel searchDetailsPanel;
    private final JTextArea textArea;

    public SearchFrame(String title) {
        super(title);

        this.searchDetailsPanel = new SearchDetailsPanel();
        this.textArea = new JTextArea();

        setLayout(new BorderLayout());

        this.searchDetailsPanel.addDetailListener(new DetailListener() {
            @Override
            public void detailEventOccurred(DetailEvent event) {
                String searchDate = event.getDetailText();
                textArea.append(searchDate);
            }
        });

        Container c = getContentPane();

        c.add(this.searchDetailsPanel, BorderLayout.WEST);
        c.add(this.textArea, BorderLayout.EAST);
    }
}

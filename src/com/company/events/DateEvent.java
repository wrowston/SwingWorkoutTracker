package com.company.events;

import java.util.EventObject;

public class DateEvent extends EventObject {

    private String dateText;

    public DateEvent(Object source, String dateText) {
        super(source);

        this.dateText = dateText;
    }

    public String getDateText(){

        return this.dateText;
    }
}

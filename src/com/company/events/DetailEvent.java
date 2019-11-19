package com.company.events;

import java.util.EventObject;

public class DetailEvent extends EventObject {

    private String detailText;

    public DetailEvent(Object source, String detailText) {
        super(source);

        this.detailText = detailText;
    }

    public String getDetailText(){
        return this.detailText;
    }
}

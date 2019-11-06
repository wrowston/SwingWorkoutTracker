package com.company.events;

import java.util.EventListener;

public interface DateListener extends EventListener {

    public void dateEventOccurred(DateEvent date);
}

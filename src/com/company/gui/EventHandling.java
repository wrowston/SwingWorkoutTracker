package com.company.gui;

import com.company.events.DetailEvent;
import com.company.events.DetailListener;

import javax.swing.event.EventListenerList;

public class EventHandling {
    private EventListenerList listenerList;

    public EventHandling() {
        this.listenerList = new EventListenerList();
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

    public void removeDetailListener(DetailListener listener) {
        listenerList.remove(DetailListener.class, listener);
    }

    public EventListenerList getListenerList() {
        return listenerList;
    }
}

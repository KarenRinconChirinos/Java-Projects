package com.nikki.patrones.observer;

import java.util.ArrayList;
import java.util.List;

abstract public class Observable {
    protected List<observer> observers = new ArrayList<>();

    public void addObserver(observer o){
        observers.add(o);
    }
    
    public void removeObserver(observer o){
        observers.remove(o);
    }

    public void notifyObservers(){
        notifyObservers(null);
    }

    public void notifyObservers(Object obj){
        for(observer obs: this.observers){
            obs.update(this, obj);
        }
    }
}

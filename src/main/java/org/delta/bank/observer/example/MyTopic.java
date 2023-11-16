package org.delta.bank.observer.example;

import org.delta.bank.observer.Observer;
import org.delta.bank.observer.Subject;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class MyTopic implements  Subject{


    private  String message;
    private boolean changed;
    private Object MUTEX = new Object();

    public void MyTopic(){}

    @Override
    public void register(Observer obj) {
        if(obj == null){

            throw new NullPointerException("Null observer");

        }

        synchronized (MUTEX){
            if(!observers.contains(obj)){
                observers.add(obj);
                obj.setSubject(this);
            }

        }


    }

    @Override
    public void unregister(Observer obj) {
        synchronized (MUTEX){
            observers.remove(obj);
        }
    }

    @Override
    public void notifyObservers() {
        List<Observer> observersLocal = null;

        synchronized (MUTEX){
            if(!changed){
                return;
            }
            observersLocal = new ArrayList<>(this.observers);

            for(Observer obj: observersLocal){
                obj.update();
            }
        }

    }

    @Override
    public Object getUpdate(Observer a) {
        return this.message;
    }

    public void postMessage(String s){
        System.out.println("Message posted to topic " + s);
        this.message = s;
        this.changed = true;
        notifyObservers();
    }
}

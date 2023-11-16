package org.delta.bank.observer.example;

import org.delta.bank.observer.Observer;
import org.delta.bank.observer.Subject;

public class MyTopicSubscriber implements Observer{
    private String name;
    private Subject topic;
    public MyTopicSubscriber(String s){
        this.name = s;
    }

    @Override
    public void update() {
        String msg = (String) topic.getUpdate(this);
        if (msg == null){
            System.out.println();
        } else {
            System.out.println(name + " consuming message " + msg);
        }
    }

    @Override
    public void setSubject(Subject a) {
        this.topic = a;

    }
}

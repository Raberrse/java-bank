package org.delta.bank.observer;

public interface Observer {
    void update();
    void setSubject(Subject topic);
}

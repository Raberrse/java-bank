package org.delta.bank.observer.example;

import org.delta.bank.observer.Observer;

public class TestObservers {
    public static void main(String[] args) {
        MyTopic topic = new MyTopic();;

        Observer obj1 = new MyTopicSubscriber("Obj1");
        Observer obj2 = new MyTopicSubscriber("Obj2");
        Observer obj3 = new MyTopicSubscriber("Obj3");

        topic.register(obj1);
        topic.register(obj2);
        topic.register(obj3);

        obj1.update();

        topic.postMessage("New message");
    }
}

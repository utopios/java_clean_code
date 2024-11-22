package com.example.correctionapp.service;

import com.example.correctionapp.observer.Observer;
import com.example.correctionapp.observer.Subject;

import java.util.ArrayList;
import java.util.List;

public class NotificationService implements Subject<String> {
    private final List<Observer> observers = new ArrayList<>();
    @Override
    public void addObserver(Observer observer) {
        if (observer != null && !observers.contains(observer)) {
            observers.add(observer);
        }
    }

    @Override
    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers(String message) {
        for (Observer observer : observers) {
            if(observer != null)
                observer.update(message);
        }
    }
}

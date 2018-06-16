package com.github.kbednarz.issuetrackingsystem.observer;

public interface Subject {
    void addObserver(Observer obj);

    void removeObserver(Observer obj);

    void notifyObservers();
}

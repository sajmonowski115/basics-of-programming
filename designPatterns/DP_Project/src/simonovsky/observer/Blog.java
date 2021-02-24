package simonovsky.observer;

import java.util.*;
import java.lang.*;

public class Blog implements Observable {
    private Set<Observer> observers = new HashSet<>();
    private String newestArticle;

    @Override
    public void attach(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void detach(Observer observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers() {
        observers.forEach(Observer::update);
    }

    public String getNewestArticle() {
        return newestArticle;
    }

    public void publishArticle(String article) {
        this.newestArticle = article;
        notifyObservers();
    }
}

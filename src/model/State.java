package src.model;

import java.util.List;
import java.util.ArrayList;

import src.enums.Mode;
import src.interfaces.StateObserver;

public class State {
    private Mode state;

    private final List<StateObserver> observers = new ArrayList<>();

    public State() {
        state = Mode.VIEW;
    }

    public void setState(Mode newState) {
        state = newState;
        notifyObservers();
    }

    public Mode getState() {
        return state;
    }

    public void addObserver(StateObserver observer) {
        observers.add(observer);
    }

    public void notifyObservers() {
        for (StateObserver observer : observers) {
            observer.update(state);
        }
    }
}

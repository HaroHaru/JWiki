package src.model;

import src.enums.Mode;

public class State {
    private Mode state;

    public State() {
        state = Mode.VIEW;
    }

    public void setState(Mode newState) {
        state = newState;
    }

    public Mode getState() {
        return state;
    }
}

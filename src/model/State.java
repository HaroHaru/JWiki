package src.model;

import src.util.Mode;

public class State {
    private Mode state;

    public State() {
        state = Mode.VIEW;
    }

    public State(Mode mode) {
        state = mode;
    }

    public Mode getState() {
        return state;
    }

    public void setState(Mode newState) {
        state = newState;
    }
}

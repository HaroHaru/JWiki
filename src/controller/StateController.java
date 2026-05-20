package src.controller;

import src.etc.Mode;
import src.model.State;

public class StateController {
    State state;

    public StateController(State state) {
        this.state = state;
    }

    public void setState(Mode mode) {
        state.setState(mode);
    }
}
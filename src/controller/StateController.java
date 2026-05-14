package src.controller;

import java.awt.event.ActionListener;

import src.enums.Buttons;
import src.enums.Mode;
import src.model.State;
import src.view.MainFrame;

public class StateController {
    State state;
    MainFrame view;

    public StateController(State state, MainFrame view) {
        this.state = state;
        this.view = view;
        addToolbarListener();
    }

    private void addToolbarListener() {
        ActionListener[] listeners = new ActionListener[Buttons.values().length];
        listeners[Buttons.VIEW.getValue()] = (e -> setState(Mode.VIEW));
        listeners[Buttons.EDIT.getValue()] = (e -> setState(Mode.EDIT));
        view.setToolbarListener(listeners);
    }

    private void setState(Mode mode) {
        state.setState(mode);
    }
}
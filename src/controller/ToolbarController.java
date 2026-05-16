package src.controller;

import java.awt.event.ActionListener;

import src.enums.Buttons;
import src.enums.Mode;
import src.view.MainFrame;

public class ToolbarController {
    ContentController contentController;
    EditorController editorController;
    StateController stateController;
    MainFrame view;

    public ToolbarController(MainFrame view, ContentController contentController, EditorController editorController,
            StateController stateController) {
        this.view = view;
        this.contentController = contentController;
        this.editorController = editorController;
        this.stateController = stateController;
        addToolbarListener();
    }

    private void addToolbarListener() {
        ActionListener[] listeners = new ActionListener[Buttons.values().length];
        listeners[Buttons.VIEW.getValue()] = (e -> viewButton());
        listeners[Buttons.EDIT.getValue()] = (e -> editButton());
        listeners[Buttons.SAVE.getValue()] = (e -> saveButton());
        view.setToolbarListener(listeners);
    }

    private void viewButton() {
        Mode mode = Mode.VIEW;
        stateController.setState(mode);
        contentController.update(mode);
    }

    private void editButton() {
        Mode mode = Mode.EDIT;
        stateController.setState(mode);
        contentController.update(mode);
    }

    private void saveButton() {
        Mode mode = Mode.VIEW;
        editorController.updateDocument();
        stateController.setState(mode);
        contentController.update(mode);
    }
}

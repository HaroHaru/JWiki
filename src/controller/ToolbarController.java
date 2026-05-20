package src.controller;

import java.awt.event.ActionListener;

import src.enums.Buttons;
import src.enums.EditerButtons;
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
        ActionListener[] editorListeners = new ActionListener[EditerButtons.values().length];

        listeners[Buttons.VIEW.getValue()] = (e -> viewButton());
        listeners[Buttons.EDIT.getValue()] = (e -> editButton());
        listeners[Buttons.SAVE.getValue()] = (e -> saveButton());
        listeners[Buttons.CREATE.getValue()] = (e -> createButton());
        listeners[Buttons.DELETE.getValue()] = (e -> deleteButton());

        editorListeners[EditerButtons.H1.getValue()] = (e -> tagButton("h1"));
        editorListeners[EditerButtons.H2.getValue()] = (e -> tagButton("h2"));
        editorListeners[EditerButtons.H3.getValue()] = (e -> tagButton("h3"));
        editorListeners[EditerButtons.BOLD.getValue()] = (e -> tagButton("strong"));
        editorListeners[EditerButtons.ITALIC.getValue()] = (e -> tagButton("i"));
        editorListeners[EditerButtons.STRIKE.getValue()] = (e -> tagButton("del"));
        editorListeners[EditerButtons.LINK.getValue()] = (e -> linkButton());

        view.setToolbarListener(listeners, editorListeners);
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
        if (editorController.updatePage()) {
            stateController.setState(mode);
            contentController.update(mode);
        }
    }

    private void createButton() {
        Mode mode = Mode.VIEW;
        if (editorController.createPage()) {
            stateController.setState(mode);
            contentController.update(mode);
        }
    }

    private void deleteButton() {

    }

    private void tagButton(String tag) {
        view.setTag(tag);
    }

    private void linkButton() {
        view.setLink();
    }
}

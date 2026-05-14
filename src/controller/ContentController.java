package src.controller;

import src.view.MainFrame;
import src.enums.Mode;
import src.interfaces.StateObserver;
import src.model.Document;

public class ContentController implements StateObserver {
    private Document document;
    private MainFrame view;

    public ContentController(Document document, MainFrame view, Mode mode) {
        this.document = document;
        this.view = view;
        update(mode);
    }

    @Override
    public void update(Mode mode) {
        setContent(mode);
    }

    private void setContent(Mode mode) {
        view.setContent(document.getTitle(), document.getContent(), mode);
    }
}

package src.controller;

import src.view.MainFrame;
import src.enums.Mode;
import src.model.Document;

public class ContentController {
    private Document document;
    private MainFrame view;

    public ContentController(Document document, MainFrame view, Mode mode) {
        this.document = document;
        this.view = view;
        update(mode);
    }

    public void update(Mode mode) {
        document.updateDocument();
        setContent(mode);
    }

    private void setContent(Mode mode) {
        view.setContent(document.getTitle(), document.getContent(), mode);
    }
}

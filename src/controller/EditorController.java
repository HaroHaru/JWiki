package src.controller;

import src.model.Document;
import src.service.WikiPageService;
import src.view.MainFrame;

public class EditorController {
    WikiPageService service;
    Document document;
    MainFrame view;

    public EditorController(MainFrame view, Document document) {
        service = new WikiPageService();
        this.document = document;
        this.view = view;
    }

    public void updateDocument() {
        String updatedContent = view.getEditedContent();
        service.update(document.getTitle(), updatedContent);
    }
}

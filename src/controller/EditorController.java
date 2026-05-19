package src.controller;

import src.model.Page;
import src.service.WikiPageService;
import src.view.MainFrame;

public class EditorController {
    WikiPageService service;
    Page page;
    MainFrame view;

    public EditorController(MainFrame view, Page page) {
        service = new WikiPageService();
        this.page = page;
        this.view = view;
    }

    public void updatePage() {
        String updatedContent = view.getEditedContent();
        service.update(page.getTitle(), updatedContent);
    }
}

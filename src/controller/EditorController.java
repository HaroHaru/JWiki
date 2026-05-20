package src.controller;

import javax.swing.JOptionPane;

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

    public boolean updatePage() {
        if (!service.exists(page.getTitle())) {
            JOptionPane.showMessageDialog(
                    view,
                    "Document does not exist\nPlease click the \"Create\" Button\nto create the document",
                    "404 NOT FOUND",
                    JOptionPane.ERROR_MESSAGE);
            return false;
        }
        String updatedContent = view.getEditedContent();
        service.update(page.getTitle(), updatedContent);
        return true;
    }

    public boolean createPage() {
        if (service.exists(page.getTitle())) {
            JOptionPane.showMessageDialog(
                    view,
                    "Document exist\nPlease click the \"Edit\" Button\nto edit the document",
                    "409 Conflict",
                    JOptionPane.ERROR_MESSAGE);
            return false;
        }
        String newContent = view.getEditedContent();
        service.create(page.getTitle(), newContent);
        return true;
    }
}

package src.controller;

import java.awt.event.ActionListener;

import src.view.MainFrame;

public class SearchController {
    private MainFrame view;
    private ContentController contentController;

    public SearchController(MainFrame view, ContentController contentController) {
        this.view = view;
        this.contentController = contentController;
        setSearch();
    }

    public void setSearch() {
        ActionListener listener = (e -> search());

        view.setSearch(listener);
    }

    public void search() {
        String search = view.getSearch();
        if (!search.isEmpty()) {
            contentController.move(search, false);
        }
    }
}

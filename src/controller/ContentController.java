package src.controller;

import src.view.MainFrame;
import src.enums.Mode;
import src.model.Page;

public class ContentController {
    private Page page;
    private MainFrame view;

    public ContentController(Page page, MainFrame view, Mode mode) {
        this.page = page;
        this.view = view;
        update(mode);
    }

    public void update(Mode mode) {
        page.updatePage();
        setContent(mode);
    }

    private void setContent(Mode mode) {
        view.setContent(page.getTitle(), page.getContent(), mode);
    }
}

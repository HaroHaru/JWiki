package src.controller;

import src.view.MainFrame;
import src.etc.Mode;
import src.model.Page;

public class ContentController {
    private Page page;
    private MainFrame view;
    private SidebarController sidebarController;

    public ContentController(Page page, MainFrame view, Mode mode, SidebarController sidebarController) {
        this.page = page;
        this.view = view;
        this.sidebarController = sidebarController;
        update(mode);
    }

    public void update(Mode mode) {
        page.updatePage();
        setContent(mode);
    }

    public void move(String title) {
        if (page.updatePage(title)) {
            setContent(Mode.VIEW);
        } else {
            setContent(Mode.EDIT);
        }
    }

    private void setContent(Mode mode) {
        view.setContent(page.getTitle(), page.getContent(), mode);
        sidebarController.setSidebar();
    }
}

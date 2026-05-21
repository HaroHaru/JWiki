package src.controller;

import src.view.MainFrame;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import src.etc.Mode;
import src.model.Page;

public class ContentController {
    private Page page;
    private MainFrame view;
    private SidebarController sidebarController;
    private List<String> history;

    public ContentController(Page page, MainFrame view, Mode mode, SidebarController sidebarController) {
        this.page = page;
        this.view = view;
        this.sidebarController = sidebarController;
        history = new ArrayList<>();
        update(mode);
    }

    public void update(Mode mode) {
        page.updatePage();
        setContent(mode);
    }

    public void move(String title, boolean prev) {
        if (!prev) {
            history.add(page.getTitle());
        }
        if (page.updatePage(title)) {
            setContent(Mode.VIEW);
        } else {
            setContent(Mode.EDIT);
        }
    }

    public void prev() {
        if (history.isEmpty()) {
            JOptionPane.showMessageDialog(
                    view,
                    "History is empty",
                    "404 Not Found",
                    JOptionPane.ERROR_MESSAGE);
            return;
        }

        String title = history.getLast();
        history.removeLast();
        move(title, true);
    }

    private void setContent(Mode mode) {
        view.setContent(page.getTitle(), page.getContent(), mode);
        sidebarController.setSidebar();
    }
}

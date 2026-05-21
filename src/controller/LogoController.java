package src.controller;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import src.view.MainFrame;

public class LogoController {
    private MainFrame view;
    private ContentController contentController;

    public LogoController(MainFrame view, ContentController contentController) {
        this.view = view;
        this.contentController = contentController;
        setLogoListener();
    }

    private void setLogoListener() {
        MouseAdapter listener = new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                moveToMain();
            }
        };
        view.setLogoListener(listener);
    }

    private void moveToMain() {
        contentController.move("Main", false);
    }
}

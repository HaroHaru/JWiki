package src.controller;

import javax.swing.event.HyperlinkEvent;
import javax.swing.event.HyperlinkListener;

import src.view.MainFrame;

public class DocLinkController {
    private MainFrame view;
    private ContentController contentController;

    public DocLinkController(MainFrame view, ContentController contentController) {
        this.view = view;
        this.contentController = contentController;
        setLinkListener();
    }

    private void setLinkListener() {
        HyperlinkListener listener = (e -> linkClicked(e));
        view.setLinkListener(listener);
    }

    private void linkClicked(HyperlinkEvent e) {
        if (e.getEventType() == HyperlinkEvent.EventType.ACTIVATED) {
            contentController.move(e.getDescription(), false);
        }
    }
}

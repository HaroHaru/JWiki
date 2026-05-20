package src.view.main.content.pages;

import javax.swing.JScrollPane;
import javax.swing.event.HyperlinkListener;
import javax.swing.JEditorPane;
import javax.swing.text.DefaultCaret;

import src.service.PageFormatter;

public class ContentViewer extends JScrollPane {
    private PageFormatter formatter;
    private JEditorPane content;

    public ContentViewer() {
        formatter = new PageFormatter();
        content = new JEditorPane() {
            @Override
            public boolean getScrollableTracksViewportWidth() {

                return true;
            }
        };

        content.setContentType("text/html");
        content.setEditable(false);
        content.setFocusable(false);

        DefaultCaret caret = (DefaultCaret) content.getCaret();
        caret.setVisible(false);
        caret.setSelectionVisible(true);

        setViewportView(content);
    }

    public void setContent(String title, String content) {
        this.content.setText(formatter.format(title, content));
    }

    public void setLinkListener(HyperlinkListener listener) {
        content.addHyperlinkListener(listener);
    }
}

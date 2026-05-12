package src.view.pages;

import javax.swing.JTextArea;

import src.util.PageFormatter;

public class ContentEditer extends JTextArea {
    private JTextArea textArea;
    private PageFormatter formatter;

    public ContentEditer() {
        formatter = new PageFormatter();

        setLineWrap(true);
        setWrapStyleWord(true);

        add(textArea);
    }

    public void setContent(String title, String content) {
        setText(formatter.format(title, content));
    }
}

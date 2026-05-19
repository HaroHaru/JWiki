package src.view.main.content.pages;

import java.awt.BorderLayout;

import javax.swing.JTextArea;
import javax.swing.text.BadLocationException;
import javax.swing.text.Document;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class ContentEditer extends JPanel {
    private JLabel title;
    private JTextArea content;

    public ContentEditer() {
        title = new JLabel();
        content = new JTextArea();

        content.setLineWrap(true);
        content.setWrapStyleWord(true);

        setLayout(new BorderLayout());
        add(title, BorderLayout.NORTH);
        add(content, BorderLayout.CENTER);
    }

    public void setContent(String title, String content) {
        this.title.setText(title);
        this.content.setText(content);
    }

    public String getEditedContent() {
        return content.getText();
    }

    public void setTag(String tag) {
        Document document = content.getDocument();

        int start = content.getSelectionStart();
        int end = content.getSelectionEnd();
        String selected = content.getSelectedText();

        try {
            if (start == end) {
                document.insertString(start, "<" + tag + "></" + tag + ">", null);
            } else {
                document.remove(start, end - start);
                document.insertString(start, "<" + tag + ">" + selected + "</" + tag + ">", null);
            }
        } catch (BadLocationException e) {
            e.printStackTrace();
        }
    }

    public void setLink() {
        String link = JOptionPane.showInputDialog(
                null, "Enter Link");

        if (link == null || link.isBlank()) {
            return;
        }

        Document document = content.getDocument();

        int start = content.getSelectionStart();
        int end = content.getSelectionEnd();
        String selected = content.getSelectedText();

        try {
            if (start == end) {
                document.insertString(start, "<a href='" + link + "'></a>", null);
            } else {
                document.remove(start, end - start);
                document.insertString(start, "<a href='" + link + "'>" + selected + "</a>", null);
            }
        } catch (BadLocationException e) {
            e.printStackTrace();
        }
    }
}

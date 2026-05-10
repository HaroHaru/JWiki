package src.view.panel;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import src.util.PageFormatter;

public class ContentPanel extends JPanel {
    private PageFormatter formatter;
    private JTextArea textArea;

    public ContentPanel() {
        formatter = new PageFormatter();
        textArea = new JTextArea();

        textArea.setEditable(false);
        textArea.setLineWrap(true);
        textArea.setWrapStyleWord(true);

        setLayout(new BorderLayout());

        add(new JScrollPane(textArea), BorderLayout.CENTER);

        setBackground(Color.WHITE);
    }

    public void setContent(String title, String content) {
        textArea.setText(formatter.format(title, content));
    }
}

package src.view.main.header;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class SearchBar extends JPanel {
    JTextField textField;
    JButton searchButton;

    public SearchBar(int height) {
        textField = new JTextField();
        searchButton = new JButton("Go");

        setPreferredSize(new Dimension((height - 10) * 7, height - 10));
        setLayout(new BorderLayout());

        add(textField, BorderLayout.CENTER);
        add(searchButton, BorderLayout.EAST);
    }

    public void setSearch(ActionListener listener) {
        searchButton.addActionListener(listener);
    }

    public String getSearch() {
        String search = textField.getText();
        textField.setText("");
        return search;
    }
}
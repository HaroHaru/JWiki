package src.view.main.content;

import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JToolBar;

import src.enums.Buttons;

public class ContentToolbar extends JToolBar {
    JButton viewButton;
    JButton editButton;

    public ContentToolbar() {
        viewButton = new JButton("View");
        editButton = new JButton("Edit");

        add(viewButton);
        add(editButton);
    }

    public void setToolbarListener(ActionListener[] listeners) {
        viewButton.addActionListener(listeners[Buttons.VIEW.getValue()]);
        editButton.addActionListener(listeners[Buttons.EDIT.getValue()]);
    }
}

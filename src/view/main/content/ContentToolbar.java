package src.view.main.content;

import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JToolBar;

import src.enums.Buttons;
import src.enums.Mode;

public class ContentToolbar extends JToolBar {
    JButton viewButton;
    JButton editButton;
    JButton saveButton;
    JButton createButton;
    JButton deleteButton;

    public ContentToolbar() {
        viewButton = new JButton("View");
        editButton = new JButton("Edit");
        saveButton = new JButton("Save");
        createButton = new JButton("Create");
        deleteButton = new JButton("Delete");

        add(viewButton);
        add(editButton);
        add(saveButton);
        add(createButton);
        add(deleteButton);
    }

    public void setToolbarListener(ActionListener[] listeners) {
        viewButton.addActionListener(listeners[Buttons.VIEW.getValue()]);
        editButton.addActionListener(listeners[Buttons.EDIT.getValue()]);
        saveButton.addActionListener(listeners[Buttons.SAVE.getValue()]);
    }

    public void setMode(Mode mode) {
        boolean isView = mode == Mode.VIEW;

        viewButton.setVisible(isView);
        editButton.setVisible(isView);

        saveButton.setVisible(!isView);
        createButton.setVisible(!isView);
        deleteButton.setVisible(!isView);
    }
}

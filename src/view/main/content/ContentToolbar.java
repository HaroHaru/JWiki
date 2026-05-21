package src.view.main.content;

import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JToolBar;

import src.etc.Buttons;
import src.etc.EditerButtons;
import src.etc.Mode;

public class ContentToolbar extends JToolBar {
    JButton prevButton;
    JButton viewButton;
    JButton editButton;
    JButton saveButton;
    JButton createButton;
    JButton deleteButton;

    JButton h1Button;
    JButton h2Button;
    JButton h3Button;
    JButton boldButton;
    JButton italicButton;
    JButton strikeButton;
    JButton linkButton;

    public ContentToolbar() {
        prevButton = new JButton("Prev");
        viewButton = new JButton("View");
        editButton = new JButton("Edit");
        saveButton = new JButton("Save");
        createButton = new JButton("Create");
        deleteButton = new JButton("Delete");

        add(prevButton);

        addSeparator();

        add(viewButton);
        add(editButton);
        add(saveButton);
        add(createButton);
        add(deleteButton);

        addSeparator();

        h1Button = new JButton("H1");
        h2Button = new JButton("H2");
        h3Button = new JButton("H3");
        boldButton = new JButton("Bold");
        italicButton = new JButton("Italic");
        strikeButton = new JButton("Strike");
        linkButton = new JButton("Link");

        add(h1Button);
        add(h2Button);
        add(h3Button);
        add(boldButton);
        add(italicButton);
        add(strikeButton);
        add(linkButton);
    }

    public void setToolbarListener(ActionListener[] listeners, ActionListener[] editorListeners) {
        prevButton.addActionListener(listeners[Buttons.PREV.getValue()]);
        viewButton.addActionListener(listeners[Buttons.VIEW.getValue()]);
        editButton.addActionListener(listeners[Buttons.EDIT.getValue()]);
        saveButton.addActionListener(listeners[Buttons.SAVE.getValue()]);
        createButton.addActionListener(listeners[Buttons.CREATE.getValue()]);
        deleteButton.addActionListener(listeners[Buttons.DELETE.getValue()]);

        h1Button.addActionListener(editorListeners[EditerButtons.H1.getValue()]);
        h2Button.addActionListener(editorListeners[EditerButtons.H2.getValue()]);
        h3Button.addActionListener(editorListeners[EditerButtons.H3.getValue()]);
        boldButton.addActionListener(editorListeners[EditerButtons.BOLD.getValue()]);
        italicButton.addActionListener(editorListeners[EditerButtons.ITALIC.getValue()]);
        strikeButton.addActionListener(editorListeners[EditerButtons.STRIKE.getValue()]);
        linkButton.addActionListener(editorListeners[EditerButtons.LINK.getValue()]);
    }

    public void setMode(Mode mode) {
        boolean isView = mode == Mode.VIEW;

        prevButton.setVisible(isView);
        viewButton.setVisible(isView);
        editButton.setVisible(isView);

        saveButton.setVisible(!isView);
        createButton.setVisible(!isView);
        deleteButton.setVisible(!isView);

        h1Button.setVisible(!isView);
        h2Button.setVisible(!isView);
        h3Button.setVisible(!isView);
        boldButton.setVisible(!isView);
        italicButton.setVisible(!isView);
        strikeButton.setVisible(!isView);
        linkButton.setVisible(!isView);
    }
}

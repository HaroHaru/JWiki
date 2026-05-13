package src.view.components;

import javax.swing.JButton;
import javax.swing.JToolBar;

public class ContentToolbar extends JToolBar {
    JButton viewButton;
    JButton editButton;

    public ContentToolbar() {
        viewButton = new JButton("View");
        editButton = new JButton("Edit");
    }
}

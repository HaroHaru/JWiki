package src.view.main;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionListener;
import java.awt.event.MouseListener;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.event.DocumentListener;

import src.view.main.header.SearchBar;

public class HeaderPanel extends JPanel {
    JPanel logo;
    SearchBar searchBar;

    public HeaderPanel(int height) {
        logo = new Logo();
        logo.setPreferredSize(new Dimension((height - 10) * 3, height - 10));

        searchBar = new SearchBar(height);

        setLayout(new BorderLayout());
        setBorder(BorderFactory.createEmptyBorder(5, 40, 5, 40));

        add(logo, BorderLayout.WEST);
        add(searchBar, BorderLayout.EAST);

        setPreferredSize(new Dimension(0, height));
        setBackground(Color.LIGHT_GRAY);
    }

    public void setLogoListener(MouseListener listener) {
        logo.addMouseListener(listener);
    }

    public void setSearch(ActionListener listener) {
        searchBar.setSearch(listener);
    }

    public String getSearch() {
        return searchBar.getSearch();
    }
}

class Logo extends JPanel {
    private ImageIcon logo = new ImageIcon("./resources/logo.png");
    private Image img = logo.getImage();

    public Logo() {
        setBackground(new Color(0, 0, 0, 0));
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(img, 0, 0, getWidth(), getHeight(), this);
    }
}

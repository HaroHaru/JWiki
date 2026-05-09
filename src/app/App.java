package src.app;

import javax.swing.*;

class MainFrame extends JFrame {
    MainFrame() {
        JFrame frame = new JFrame();

        setTitle("JWiki");

        frame.setSize(400, 300);
        frame.setVisible(true);
    }
}

public class App {
    public static void main(String[] args) {
        MainFrame frame = new MainFrame();
    }
}

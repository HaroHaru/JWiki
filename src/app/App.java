package src.app;

import src.model.WikiPageService; // need to erase
import src.view.main.MainFrame;

public class App {
    public static void main(String[] args) {
        WikiPageService service = new WikiPageService();

        if (!service.exists("Main")) {
            service.create("Main", "# Temporation Page");
        }

        MainFrame frame = new MainFrame(800, 600, 50, 200);

        String content = service.read("Main");

        frame.setContent("Main", content);
    }
}

package src.app;

import src.model.Document;
import src.model.State;
import src.service.WikiPageService;
import src.view.MainFrame;

public class App {
    public static void main(String[] args) {
        WikiPageService service = new WikiPageService();

        if (!service.exists("Main")) {
            service.create("Main", "# Temporary Page");
        }

        Document document = new Document("Main");
        State state = new State();

        MainFrame frame = new MainFrame(800, 600, 50, 200);
    }
}

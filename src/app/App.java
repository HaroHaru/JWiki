package src.app;

import src.service.WikiPageService;
import src.view.*;

public class App {
    public static void main(String[] args) {
        WikiPageService service = new WikiPageService();
        if (!service.exists("Main")) {
            service.create("Main", "# 임시 제목입니다.");
        }

        MainFrame frame = new MainFrame(800, 600, 50, 200);
    }
}

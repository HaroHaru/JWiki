package src.model;

import src.service.WikiPageService;

public class Page {
    private String title;
    private String content;
    private WikiPageService service;

    public Page() {
        service = new WikiPageService();

        if (!service.exists("Main")) {
            service.create("Main", "# Temporary Page");
        }

        title = "Main";
        content = service.read(title);
    }

    public String getTitle() {
        return title;
    }

    public String getContent() {
        return content;
    }

    public void updatePage() {
        content = service.read(title);
    }

    public void updatePage(String title) {
        this.title = title;
        content = service.read(title);
    }

    public void deletePage() {
        title = "";
        content = "";
    }
}

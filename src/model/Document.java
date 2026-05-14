package src.model;

import src.service.WikiPageService;

public class Document {
    private String title;
    private String content;
    private WikiPageService service;

    public Document() {
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

    public void updateDocument() {
        content = service.read(title);
    }

    public void updateDocument(String title) {
        this.title = title;
        content = service.read(title);
    }

    public void deleteDocument() {
        title = "";
        content = "";
    }
}

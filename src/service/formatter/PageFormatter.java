package src.service.formatter;

public class PageFormatter {
    public String format(String title, String content) {
        return htmlInit("<h1>" + title + "</h1>" + content);
    }

    private String htmlInit(String content) {
        return "<html><body style='overflow-wrap: break-word; word-break: break-all;'>"
                + content +
                "</body></html>";
    }
}
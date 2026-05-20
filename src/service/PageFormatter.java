package src.service;

public class PageFormatter {
    public String format(String title, String content) {
        content = removeNewLine(content, "</h1>");
        content = removeNewLine(content, "</h2>");
        content = removeNewLine(content, "</h3>");
        content = content.replace("\n", "<br>");
        return htmlInit("<h1>" + title + "</h1>" + content);
    }

    private String htmlInit(String content) {
        return "<html><body style='overflow-wrap: break-word; word-break: break-all; white-space: pre-wrap;'>"
                + content +
                "</body></html>";
    }

    private String removeNewLine(String content, String sample) {
        return content.replace(sample + "\n", sample);
    }
}
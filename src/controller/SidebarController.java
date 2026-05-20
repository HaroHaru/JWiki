package src.controller;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.ArrayList;

import src.etc.Header;
import src.model.Page;
import src.view.MainFrame;

public class SidebarController {
    private Page page;
    private MainFrame view;

    public SidebarController(Page page, MainFrame view) {
        this.page = page;
        this.view = view;
    }

    public void setSidebar() {
        List<Header> tableOfContents = new ArrayList<>();
        Pattern pattern = Pattern.compile(
                "<h([1-3])>(.*?)</h\\1>",
                Pattern.CASE_INSENSITIVE);

        Matcher matcher = pattern.matcher(page.getContent());

        while (matcher.find()) {
            int level = Integer.parseInt(matcher.group(1));
            String content = matcher.group(2);

            tableOfContents.add(new Header(level, content));
        }

        view.setSidebar(tableOfContents);
    }
}

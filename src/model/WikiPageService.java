package src.model;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

import src.util.PathManager;

public class WikiPageService {
    public boolean exists(String title) {
        File file = new File(PathManager.PAGES, title + ".md");
        return file.exists();
    }

    public void create(String title, String content) {
        try {
            File pagesDir = new File(PathManager.PAGES);

            if (!pagesDir.exists()) {
                pagesDir.mkdirs();
            }

            Path path = Path.of(PathManager.PAGES, title + ".md");

            Files.writeString(path, content);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String read(String title) {
        try {
            Path path = Path.of(PathManager.PAGES, title + ".md");

            return Files.readString(path);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return "";
    }
}

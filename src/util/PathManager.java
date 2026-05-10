package src.util;

import java.io.File;

public class PathManager {
    public static final String ROOT = (System.getProperty("user.home") +
            File.separator +
            ".JWiki");

    public static final String PAGES = (ROOT + File.separator + "pages");
}

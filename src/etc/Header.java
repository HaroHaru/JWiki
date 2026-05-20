package src.etc;

public class Header {
    private int level;
    private String title;

    public Header(int level, String title) {
        this.level = level;
        this.title = title;
    }

    public int getLevel() {
        return level;
    }

    public String getTitle() {
        return title;
    }
}

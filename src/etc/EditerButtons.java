package src.etc;

public enum EditerButtons {
    H1(0), H2(1), H3(2), BOLD(3), ITALIC(4), STRIKE(5), LINK(6);

    private final int value;

    EditerButtons(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}

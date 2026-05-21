package src.etc;

public enum Buttons {
    PREV(0), VIEW(1), EDIT(2), SAVE(3), DELETE(4), CREATE(5);

    private final int value;

    Buttons(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}

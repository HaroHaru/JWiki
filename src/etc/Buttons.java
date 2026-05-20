package src.etc;

public enum Buttons {
    VIEW(0), EDIT(1), SAVE(2), DELETE(3), CREATE(4);

    private final int value;

    Buttons(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}

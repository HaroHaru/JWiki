package src.interfaces;

import src.enums.Mode;

public interface StateObserver {
    public void update(Mode mode);
}
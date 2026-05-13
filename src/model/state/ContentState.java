package src.model.state;

public class ContentState {
    private Mode state;

    public ContentState() {
        state = Mode.VIEW;
    }

    public Mode getState() {
        return state;
    }

    public void setState(Mode newState) {
        state = newState;
    }

    public void setEditMode() {
        state = Mode.EDIT;
    }

    public void setViewMode() {
        state = Mode.VIEW;
    }

    public void setNotFoundMode() {
        state = Mode.NOT_FOUND;
    }
}

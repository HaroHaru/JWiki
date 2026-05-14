package src.app;

import src.controller.ContentController;
import src.controller.StateController;
import src.model.Document;
import src.model.State;
import src.view.MainFrame;

public class App {
    public static void main(String[] args) {
        Document document = new Document();
        State state = new State();

        MainFrame frame = new MainFrame(800, 600, 50, 200);

        ContentController contentController = new ContentController(document, frame, state.getState());
        StateController stateController = new StateController(state, frame);

        state.addObserver(contentController);
    }
}

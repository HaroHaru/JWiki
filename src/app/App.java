package src.app;

import src.controller.ContentController;
import src.controller.DocLinkController;
import src.controller.EditorController;
import src.controller.LogoController;
import src.controller.SidebarController;
import src.controller.StateController;
import src.controller.ToolbarController;
import src.model.Page;
import src.model.State;
import src.view.MainFrame;

public class App {
    public static void main(String[] args) {
        Page page = new Page();
        State state = new State();

        MainFrame frame = new MainFrame(800, 600, 50, 200);

        SidebarController sidebarController = new SidebarController(page, frame);
        ContentController contentController = new ContentController(page, frame, state.getState(), sidebarController);
        StateController stateController = new StateController(state);
        EditorController editorController = new EditorController(frame, page);
        ToolbarController toolbarController = new ToolbarController(frame, contentController, editorController,
                stateController);
        DocLinkController docLinkController = new DocLinkController(frame, contentController);
        LogoController logoController = new LogoController(frame, contentController);
    }
}

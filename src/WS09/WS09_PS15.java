package WS09;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class WS09_PS15 extends Application {

    private TextArea ta;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Text Editor");

        // Creating menu items
        MenuItem cut = new MenuItem("Cut");
        MenuItem copy = new MenuItem("Copy");
        MenuItem paste = new MenuItem("Paste");
        MenuItem selectAll = new MenuItem("Select All");

        // Adding action handlers
        cut.setOnAction(_ -> ta.cut());
        copy.setOnAction(_ -> ta.copy());
        paste.setOnAction(_ -> ta.paste());
        selectAll.setOnAction(_ -> ta.selectAll());

        // Creating menus and adding items
        MenuBar mb = new MenuBar();
        Menu file = new Menu("File");
        Menu edit = new Menu("Edit");
        Menu help = new Menu("Help");

        edit.getItems().addAll(cut, copy, paste, selectAll);
        mb.getMenus().addAll(file, edit, help);

        // Creating text area
        ta = new TextArea();

        // Layout setup
        BorderPane root = new BorderPane();
        root.setTop(mb);
        root.setCenter(ta);

        Scene scene = new Scene(root, 400, 400);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}

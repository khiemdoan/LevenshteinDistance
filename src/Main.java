/**
 * Created by Khiem on 3/27/2016.
 */

import gui.InputPane;
import gui.TablePane;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class Main extends Application {

    public void start(Stage stage) {
        inputPane = new InputPane();

        Pane mainPane = new Pane();
        mainPane.getChildren().add(inputPane);

        TablePane table = TablePane.getInstance();
        table.relocate(0, inputPane.getHeight());
        mainPane.getChildren().add(table);

        double height = inputPane.getHeight() + table.getHeight();
        double width = inputPane.getWidth();
        Scene scene = new Scene(mainPane, width, height);
        scene.setFill(null);

        stage.setTitle("Levenshtein Distance");
        stage.setScene(scene);
        stage.show();
    }

    private InputPane inputPane;

    public static void main(String[] args) {
        launch(args);
    }
}

package gui;

import controller.Controller;
import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;

/**
 * Created by Khiem on 3/27/2016.
 */
public class InputPane extends Pane {

    private static final double WIDTH = 700;
    private static final double HEIGHT = 125;

    public InputPane() {
        resize(WIDTH, HEIGHT);
        initComponents();
    }

    private TextField tfString1;
    private TextField tfString2;
    private Button btnCompute;

    private void initComponents() {
        tfString1 = new TextField();
        tfString1.setMinSize(75, 25);
        tfString1.relocate(25, 25);
        this.getChildren().add(tfString1);

        tfString2 = new TextField();
        tfString2.setMinSize(75, 25);
        tfString2.relocate(25, 75);
        this.getChildren().add(tfString2);

        btnCompute = new Button("compute");
        btnCompute.setMinSize(25, 25);
        btnCompute.relocate(250, 50);
        this.getChildren().add(btnCompute);
        btnCompute.setOnAction((ActionEvent event) -> {
            compute();
        });
    }

    private void compute() {
        Controller controller = Controller.getInstance();

        String str1 = tfString1.getText();
        String str2 = tfString2.getText();

        controller.compute(str1, str2);

        // convert to upper case
        //controller.compute(str1.toUpperCase(), str2.toUpperCase());

        // remove whitespace
        //controller.compute(str1.replaceAll("\\s+",""), str2.replaceAll("\\s+",""));
    }
}

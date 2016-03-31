package gui;

import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;

/**
 * Created by Khiem on 3/31/2016.
 */
public class TablePane extends GridPane {

    // singleton
    private static TablePane instance = new TablePane();

    private TablePane() {
        resize(500, 500);
        setPadding(new Insets(5));
    }

    public static TablePane getInstance() {
        return instance;
    }

    public void setString1(String str1) {
        setHgap(str1.length() + 2);
        array1 = new char[str1.length()];
        str1.getChars(0, str1.length(), array1, 0);
    }

    public void setString2(String str2) {
        setVgap(str2.length() + 2);
        array2 = new char[str2.length()];
        str2.getChars(0, str2.length(), array2, 0);
    }

    private char[] array1;
    private char[] array2;

    public void draw(int[][] tableResult) {
        getChildren().clear();

        for (int i = 0; i < array1.length + 2; i++) {
            RowConstraints row = new RowConstraints(20);
            getRowConstraints().add(row);
        }

        for (int i = 0; i < array2.length + 2; i++) {
            ColumnConstraints column = new ColumnConstraints(20);
            getColumnConstraints().add(column);
        }

        for (int i = 0; i < array1.length; i++) {
            add(new Label(String.valueOf(array1[i])), 0, i + 2);
        }
        for (int j = 0; j < array2.length; j++) {
            add(new Label(String.valueOf(array2[j])), j + 2, 0);
        }

        for (int i = 0; i < tableResult.length; i++) {
            for (int j = 0; j < tableResult[i].length; j++) {
                add(new Label(String.valueOf(tableResult[i][j])), j + 1, i + 1);
            }
        }
    }
}

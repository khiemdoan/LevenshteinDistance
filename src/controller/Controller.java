package controller;

import core.LevenshteinDistanceCore;
import gui.TablePane;

/**
 * Created by Khiem on 3/28/2016.
 */
public class Controller {

    // singleton
    private static Controller instance = new Controller();

    private Controller() {}

    public static Controller getInstance() {
        return instance;
    }

    public void compute(String str1, String str2) {
        TablePane tablePane = TablePane.getInstance();

        LevenshteinDistanceCore core = new LevenshteinDistanceCore();

        tablePane.setString1(str1);
        tablePane.setString2(str2);

        core.compute(str1, str2);
        int[][] tableResult = core.getTableResult();

        tablePane.draw(tableResult);
    }
}

package birl.Controller;

import birl.View.MainFX;
import javafx.stage.Stage;

public class Main {
    
    public static void main(String[] args) {
        // test
        DataBaseManager dbm = new DataBaseManager(
            "jdbc:postgresql://localhost:5432/birl",
            "wwwookie",
            "supersecurepwd");

        System.out.println(dbm.selectNameFromTableByID("character", 1));

        Controller c = new Controller();
        c.printData();

        try {
            MainFX view = new MainFX();
            view.start(new Stage());
        } catch (Exception e) {
            e.printStackTrace();
        }

        // all DB -> Model traffic will happen here
        //https://www.freecodecamp.org/news/the-model-view-controller-pattern-mvc-architecture-and-frameworks-explained/
        
    }
}

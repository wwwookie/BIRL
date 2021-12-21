package birl.Controller;

public class Main {
    
    public static void main(String[] args) {
        // test
        DataBaseManager dbm = new DataBaseManager(
            "jdbc:postgresql://localhost:5432/birl",
            "wwwookie",
            "supersecurepwd");

        System.out.println(dbm.selectNameFromTableByID("character", 1));

        // all DB -> Model traffic will happen here
        //https://www.freecodecamp.org/news/the-model-view-controller-pattern-mvc-architecture-and-frameworks-explained/
        
    }
}

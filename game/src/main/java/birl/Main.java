package birl;

public class Main {
    
    public static void main(String[] args) {
        // test
        DataBaseManager dbm = new DataBaseManager(
            "jdbc:postgresql://localhost:5432/birl",
            "wwwookie",
            "supersecurepwd");

        System.out.println(dbm.selectNameFromTableByID("character", 1));
    }
}

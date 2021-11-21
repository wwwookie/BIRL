package birl;

public class Main {
    
    public static void main(String[] args) {
        // test
        DataBaseManager dbm = new DataBaseManager(
            "jdbc:postgresql://localhost:5432/birl",
            "wwwookie",
            "supersecurepwd");

        dbm.executeQuery("SELECT * FROM type");
    }
}

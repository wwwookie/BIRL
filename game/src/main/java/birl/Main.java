package birl;

public class Main {
    
    // test
    DataBaseManager dbm = new DataBaseManager(
        "jdbc:postgresql://localhost:5432/birl",
        "wwwookie",
        "supersecurepwd",
        "SELECT * FROM type");

    dbm.connectToDB();      // TODO: fix error here
}

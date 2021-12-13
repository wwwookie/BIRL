package birl;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class DataBaseManagerTest {
    
    // TODO: write
    DataBaseManager dbm = new DataBaseManager(
            "jdbc:postgresql://localhost:5432/birl",
            "wwwookie",
            "supersecurepwd");

    @BeforeEach
    void setUp(){
    }

    @Test
    public void getNameFromTableCorrectInput(){
        assertEquals("Drunk Douchebag", dbm.selectNameFromTableByID("character", 1));
    }

    @Test
    public void getNameFromTableNonExistingID(){
        assertEquals(null, dbm.selectNameFromTableByID("character", 0));
    }
}

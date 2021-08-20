/** Unit tests regarding Peron.java here. */

package birl;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


public class PersonTest {

    Person regularUser = new Person("regularUser", "password");
    Person admin = new Person("admin", "password");

    @BeforeEach
    void setUp(){
        regularUser = new Person("regularUser", "password");
        admin = new Person("admin", "password");
        admin.addAdminPrivilege();
    }

    /** Anti victory points cheating:
     *  passes when admin can change VP
     *  and regular users cannot
    */
    @Test
    public void addVPToPerson(){
        regularUser.setVictoryPoints(1000);
        admin.setVictoryPoints(1000);
        assertEquals(0, regularUser.getVictoryPoints());
        assertEquals(1000, admin.getVictoryPoints());
    }
}
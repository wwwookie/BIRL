/** Unit tests regarding Peron.java here. */

package birl;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


public class PersonTest {

    Person person = new Person("person", "password");

    @BeforeEach
    void setup(){
        person = new Person("person", "password"); 
    }

    /** Anti victory points cheating
     *  - passes when non-admin person
     *  cannot change it's vp.
    */
    @Test
    public void addTeamToPerson(){
        //TODO: fix test, rn it only prints out "Only admins ...", should return 0!
        person.setVictoryPoints(1000);
        assertEquals(0, person.getVictoryPoints());
    }
}
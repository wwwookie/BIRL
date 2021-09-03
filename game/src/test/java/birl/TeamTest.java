/** Unit tests regarding Team.java here. */

package birl;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import birl.Model.Fighter;
import birl.Model.Person;
import birl.Model.Team;


public class TeamTest {
    
    Person person = new Person("person", "password");
    Team team = new Team(person);

    @BeforeEach
    public void setUp(){
        person = new Person("person", "password");
        team = new Team(person);
    }

    /** Basic utilities of a team:
     *  passes when adding/removing fighter
     *  to/from team is possible
    */
    @Test
    public void addAndRemoveFighter(){
        Fighter fighter = new Fighter(0, 0, 0, team);
        
        assertEquals(fighter, team.getFighter(0));

        team.removeFighter(fighter);

        assertEquals(null, team.getFighter(0));
    }
}
/** Unit tests regarding JsonFileHandler.java here. */

package birl;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import birl.Controller.JsonFileHandler;
import birl.Model.Character;
import birl.Model.Gear;
import birl.Model.Move;


public class JsonFileHandlerTest {

    JsonFileHandler jfh = new JsonFileHandler();

    @Test
    public void checkFirstCharacterFromCharacters(){
        Character c = jfh.getCharacters()[0];

        assertEquals(1, c.getId());
        assertEquals("Drunk Douchebag", c.getName());
        assertEquals(0.0, c.getLvlScaling());
        assertEquals("Human", c.getType());
        assertEquals("This guy is that drunk, he cannot even hold his beer.", c.getAbout());

    }

    @Test
    public void checkFirstThreeNamesFromCharacters(){

        assertEquals("Drunk Douchebag", jfh.getCharacters()[0].getName());
        assertEquals("Workaholic", jfh.getCharacters()[1].getName());
        assertEquals("Gamer Guy", jfh.getCharacters()[2].getName());
    }

    @Test
    public void checkFirstGearFromGears(){
        Gear g = jfh.getGears()[0];

        assertEquals(0, g.getId());
        assertEquals("Test-Gear", g.getName());
        assertEquals(1, g.getDamage());
        assertEquals(1, g.getHeal());
        assertEquals("Human", g.getType());
        assertEquals("This gear is useless..", g.getEffect());
    }

    @Test
    public void checkFirstMoveFromMoves(){
        Move m = jfh.getMoves()[0];

        assertEquals(0, m.getId());
        assertEquals("Test-Move", m.getName());
        assertEquals(1, m.getDamage());
        assertEquals(1, m.getHeal());
        assertEquals("Human", m.getType());
        assertEquals("This move does nothing..", m.getEffect());
    }
}
/** Unit tests regarding Peron.java here. */

package birl;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.File;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import birl.Controller.TextFileHandler;
import birl.Model.Character;


public class TextFileHandlerTest {

    File homeDir = new File(System.getProperty("user.home"));
    File characters = new File(homeDir, "Desktop/BIRL/game/data/characters/characters_test.txt");
    File gears = new File(homeDir, "Desktop/BIRL/game/data/gears/gears.txt");
    TextFileHandler tfh = new TextFileHandler(characters, gears);

    @BeforeEach
    void setUp(){}

    @Test
    public void checkCharacterFromTestfile(){
        Character c = tfh.getCharacterList().get(0);

        assertEquals(1, c.getId());
        assertEquals("Drunk Douchebag", c.getName());
        assertEquals(0.0, c.getLvlScaling());
        assertEquals("Human", c.getType());
        assertEquals("This guy is that drunk, he cannot even hold his beer.", c.getAbout());

    }
}
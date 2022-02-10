/** Unit tests regarding TextFileHandler.java here. */

package birl;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.File;
import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import birl.Controller.TextFileHandler;
import birl.Model.Character;


public class TextFileHandlerTest {

    File homeDir = new File(System.getProperty("user.home"));
    File characters = new File(homeDir, "Desktop/BIRL/game/data/characters/characters.txt");
    File gears = new File(homeDir, "Desktop/BIRL/game/data/gears/gears.txt");
    File moves = new File(homeDir, "Desktop/BIRL/game/data/moves/moves.txt");
    File abilities = new File(homeDir, "Desktop/BIRL/game/data/abilities/abilities.txt");
    File effects = new File(homeDir, "Desktop/BIRL/game/data/effects/effects.txt");

    TextFileHandler tfh = new TextFileHandler(characters, gears, moves, abilities, effects);

    @BeforeEach
    void setUp(){}

    @Test
    public void checkFirstCharacterFromTestfile(){
        Character c = tfh.getCharacterList().get(0);

        assertEquals(1, c.getId());
        assertEquals("Drunk Douchebag", c.getName());
        assertEquals(0.0, c.getLvlScaling());
        assertEquals("Human", c.getType());
        assertEquals("This guy is that drunk, he cannot even hold his beer.", c.getAbout());

    }

    @Test
    public void checkFirstThreeNamesFromTestFile(){
        ArrayList <Character> characterList = tfh.getCharacterList();

        assertEquals("Drunk Douchebag", characterList.get(0).getName());
        assertEquals("Workaholic", characterList.get(1).getName());
        assertEquals("Gamer Guy", characterList.get(2).getName());
    }

    // TODO: more testing
}
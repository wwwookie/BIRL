package birl;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import birl.Controller.JsonFileHandler;
import birl.Model.Character;
import birl.Model.Fighter;
import birl.Model.Gear;

public class FighterTest {
    
    JsonFileHandler jfh = new JsonFileHandler();

    // change chosen characters here
    int characterId1 = 0;   // Drunk Douchebag
    int characterId2 = 8;   // Beer Barbar

    Character character1 = jfh.getCharacters()[characterId1];
    Character character2 = jfh.getCharacters()[characterId2];

    Fighter fighter1 = new Fighter(character1);
    Fighter fighter2 = new Fighter(character2);

    Gear testGear = jfh.getGears()[0];

    @Test
    public void checkNames(){

        assertEquals(character1.getName(), fighter1.getName());
        assertEquals(character2.getName(), fighter2.getName());
    }

    @Test
    public void do1DamageToFighter2AndDontHealSinceFull() throws Exception{

        fighter1.setGear(testGear);

        fighter1.use(0, fighter2);
        assertEquals(fighter1.getBaseHP(), fighter1.getActualHP());
        assertEquals(99, fighter2.getActualHP());

    }
}

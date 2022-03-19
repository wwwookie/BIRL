package birl.Controller;

import java.io.File;
import java.util.ArrayList;

import birl.Model.Character;
import birl.Model.Gear;
import birl.Model.Move;
import birl.Model.Ability;

// is one controller-class enough to handle whole application?
// TODO: implement
// View updates Controller with user-actions
// Controller work with model-instances, manages data
// Model is manipulated

/**
 *  Handles all data manipulation.
 */

public class Controller {
    
    ArrayList <Character> characterList;
    ArrayList <Gear> gearList;
    ArrayList <Move> moveList;
    ArrayList <Ability> abilityList;

    File homeDir;
    File characterFile;
    File gearFile;
    File moveFile;
    File abilityFile;
    File effectFile;
    
    TextFileHandler tfh;

    public Controller(){

        init();

        // manipulat data
    }

    private void init(){

        homeDir = new File(System.getProperty("user.home"));
        characterFile = new File(homeDir, "Desktop/BIRL/game/data/characters/characters.txt");
        gearFile = new File(homeDir, "Desktop/BIRL/game/data/gears/gears.txt");
        moveFile = new File(homeDir, "Desktop/BIRL/game/data/moves/moves.txt");
        abilityFile = new File(homeDir, "Desktop/BIRL/game/data/abilities/abilities.txt");
        effectFile = new File(homeDir, "Desktop/BIRL/game/data/effects/effects.txt");

        tfh  = new TextFileHandler(characterFile, gearFile, moveFile, abilityFile, effectFile);

        extractAllDataFromFiles(tfh);
    }

    private void extractAllDataFromFiles(TextFileHandler tfh){

        characterList = tfh.getCharacterList();
        gearList = tfh.getGearList();
        moveList = tfh.getMoveList();
        abilityList = tfh.getAbilityList();
    }
}

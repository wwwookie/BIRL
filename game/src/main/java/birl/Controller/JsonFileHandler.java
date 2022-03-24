package birl.Controller;

import java.io.File;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.FileReader;

import birl.Model.Gear;
import birl.Model.Character;
import birl.Model.Move;

/** Converts strings from .json files to actual BIRL objects. */
public class JsonFileHandler {
    
    private Character characters[];
    private Gear gears [];
    private Move moves[];

    private File homeDir = new File(System.getProperty("user.home"));
    private File charactersFile = new File(homeDir, "Desktop/BIRL/game/data/characters/characters.json");
    private File gearsFile = new File(homeDir, "Desktop/BIRL/game/data/gears/gears.json");
    private File movesFile = new File(homeDir, "Desktop/BIRL/game/data/moves/moves.json");

    public JsonFileHandler(){
        extractCharactersFromJSON();
        extractGearsFromJSON();
        extractMovesFromJSON();
    }

    /** Extracts all characters from a .json file. */
    private void extractCharactersFromJSON(){

        String charactersString = "";

        try (FileReader fr = new FileReader(charactersFile)){
            
            while(fr.ready()){

                charactersString += (char) fr.read();
       
            }

            try {
                ObjectMapper om = new ObjectMapper();
                this.characters = om.readValue(charactersString, Character[].class);
            } catch (JsonProcessingException e) {
                e.printStackTrace();
            }
    
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /** Extracts all gears from a .json file. */
    private void extractGearsFromJSON(){

        String gearsString = "";

        try (FileReader fr = new FileReader(gearsFile)){
            
            while(fr.ready()){

                gearsString += (char) fr.read();
       
            }

            try {
                ObjectMapper om = new ObjectMapper();
                this.gears = om.readValue(gearsString, Gear[].class);
            } catch (JsonProcessingException e) {
                e.printStackTrace();
            }
    
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /** Extracts all moves from a .json file. */
    private void extractMovesFromJSON(){
        
        String movesString = "";

        try (FileReader fr = new FileReader(movesFile)){
            
            while(fr.ready()){

                movesString += (char) fr.read();
       
            }

            try {
                ObjectMapper om = new ObjectMapper();
                this.moves = om.readValue(movesString, Move[].class);
            } catch (JsonProcessingException e) {
                e.printStackTrace();
            }
    
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Character[] getCharacters(){    return characters;   }

    public Move[] getMoves(){    return moves;   }

    public Gear[] getGears(){    return gears;   }
}

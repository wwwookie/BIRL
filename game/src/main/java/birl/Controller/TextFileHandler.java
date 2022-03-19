package birl.Controller;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.io.FileReader;
import java.io.IOException;

import birl.Model.Gear;
import birl.Model.Character;
import birl.Model.Move;
import birl.Model.Ability;

/**
 *  Converts all lines from characters.txt file to Character objects.
 *  All given Characters, Gears, Moves, Effects and Abilities are extracted from their given .txt file.
 */

public class TextFileHandler {
    
    private ArrayList <Character> characterList = new ArrayList<Character>();
    private ArrayList <Gear> gearList = new ArrayList<Gear>();
    private ArrayList <Move> moveList = new ArrayList<Move>();
    private ArrayList <Ability> abilityList = new ArrayList<Ability>();
    private ArrayList <String> effectList = new ArrayList<String>();        // needs identification (int id)?

    public TextFileHandler(File characters, File gears, File moves, File abilities, File effects){
        extractCharactersFromTextFile(characters);
        extractGearsFromTextFile(gears);
        extractMovesFromTextFile(moves);
        extractAbilitiesFromTextFile(abilities);
        extractEffectsFromTextFile(effects);
    }

    /**
     * Extracts all characters from a .txt file. File must match pattern (id; name; lvlScaling; type; about;).
     * @param characters - file to be read
     */

    private void extractCharactersFromTextFile(File characters){

        char current;
        String id = "";
        String name = "";
        String lvlScaling = "";      // using strings for all of these types
        String type = "";            // makes reading from FileReader easier
        String about = "";
        
        // .txt file is built like this:
        // id; name; lvlScaling; type; about;

        try (FileReader characterReader = new FileReader(characters)){

            while(characterReader.ready()){
                current = (char) characterReader.read();

                // read character id
                if(java.lang.Character.isDigit(current)){
                    id = id + current;

                    current = (char) characterReader.read();
                    
                    while(java.lang.Character.isDigit(current)){
                        id = id + current;
                        current = (char) characterReader.read();
                    }

                    // read character name
                    if(current == ';'){
                        current = (char) characterReader.read();

                        while(java.lang.Character.isLetter(current) || java.lang.Character.isWhitespace(current)){
                            name = name + current;
                            current = (char) characterReader.read();
                        }

                        // read character lvlScaling
                        if(current == ';'){
                            current = (char) characterReader.read();
                            
                            while(java.lang.Character.isDigit(current)){
                                lvlScaling = lvlScaling + current;
                                current = (char) characterReader.read();
                            }

                            if(current == '.'){
                                lvlScaling = lvlScaling + current;

                                current = (char) characterReader.read();

                                while(java.lang.Character.isDigit(current)){
                                    lvlScaling = lvlScaling + current;
                                    current = (char) characterReader.read();
                                }

                                // read character type
                                if(current == ';'){
                                    current = (char) characterReader.read();

                                    while(java.lang.Character.isLetter(current)){
                                        type = type + current;

                                        current = (char) characterReader.read();
                                    }

                                    // read character about
                                    if(current == ';'){
                                        current = (char) characterReader.read();

                                        while(java.lang.Character.isLetter(current) || 
                                                java.lang.Character.isWhitespace(current) ||
                                                current == '.' ||
                                                current == ','){

                                            about = about + current;

                                            current = (char) characterReader.read();
                                        }

                                        // insert collected data into list of characters
                                        characterList.add(new Character(Integer.parseInt(id), name, Double.parseDouble(lvlScaling), type, about));

                                        // reset variables
                                        id = "";
                                        name = "";
                                        lvlScaling = "";
                                        type = "";
                                        about = "";


                                    } else System.out.println("Error on reading character-file: " + current + " found but ; expected");


                                } else System.out.println("Error on reading character-file: " + current + " found but ; expected");


                            } else System.out.println("Error on reading character-file: " + current + " found but . expected");

                        } else System.out.println("Error on reading character-file: " + current + " found but ; expected");

                    } else System.out.println("Error on reading character-file: " + current + " found but ; expected");

                } else System.out.println("Error on reading character-file: " + current + " found but character ID expected.");
                
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    /**
     * Extracts all gears from a .txt file. File must match pattern ().
     * @param gears - file to be read
     */

    private void extractGearsFromTextFile(File gears){
        // TODO: implement
    }

    private void extractMovesFromTextFile(File moves){
        // TODO: implement
    }

    private void extractEffectsFromTextFile(File effects){
        // TODO: implement
    }

    private void extractAbilitiesFromTextFile(File abilities){
        // TODO: implement
    }

    public ArrayList <Character> getCharacterList(){    return characterList;   }

    public ArrayList <Gear> getGearList(){  return gearList;    }

    public ArrayList <Move> getMoveList(){  return moveList;    }

    public ArrayList <Ability> getAbilityList(){  return abilityList;    }

    public ArrayList <String> getEffectList(){  return effectList;    }
}

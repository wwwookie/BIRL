package birl.Controller;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.io.FileReader;
import java.io.IOException;

import birl.Model.Gear;
import birl.Model.Character;

public class TextFileHandler {
    
    private ArrayList characterList = new ArrayList<Character>();
    private ArrayList gearList = new ArrayList<Gear>();

    public TextFileHandler(File characters, File gears){
        extractCharactersFromTextFile(characters);
        extractGearsFromTextFile(gears);
    }

    private void extractCharactersFromTextFile(File characters){

        char current;
        
        try {
            FileReader characterReader = new FileReader(characters);

            while(characterReader.ready()){
                // read character ID
                current = (char) characterReader.read();

                if(java.lang.Character.isDigit(current)){
                    // read character name, text etc...
                    // TODO: finish

                } else System.out.println("Error on reading character-file: " + current + " found but character ID expected.");
                
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        
        // TODO: implement
    }

    private void extractGearsFromTextFile(File gears){
        // TODO: implement
    }
}

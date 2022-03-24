package birl.Controller;

import java.io.File;
import java.util.ArrayList;

import birl.Model.Character;
import birl.Model.Gear;
import birl.Model.Move;

// is one controller-class enough to handle whole application?
// TODO: implement
// View updates Controller with user-actions
// Controller work with model-instances, manages data
// Model is manipulated

/**
 *  Handles all data manipulation.
 */

public class Controller {
    
    Character characters[];
    Gear gears[];
    Move moves[];

    public Controller(){

        init();

        // manipulat data
    }

    private void init(){

        JsonFileHandler jfh = new JsonFileHandler();
        characters = jfh.getCharacters();
        gears = jfh.getGears();
        moves = jfh.getMoves();
    }

    public void printData(){
        for(Character i : characters){
            System.out.println(i.getName());
        }

        for(Gear i : gears){
            System.out.println(i.getName());
        }

        for(Move i : moves){
            System.out.println(i.getName());
        }
    }
}

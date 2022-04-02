package birl.Model;

public class Character {
    
    protected int id;
    protected double lvlScaling;
    protected String about;
    protected String type;          // making this enum might make ready Characters from file more difficult
    protected String name;
    protected int baseHP;

    public Character(){}

    public Character(int id, String name, int baseHP,double lvlScaling, String type, String about){
        this.id = id;
        this.name = name;
        this.baseHP = baseHP;
        this.lvlScaling = lvlScaling;
        this.type = type;
        this.about = about;
    }

    public int getId(){ return id;  }

    public String getName(){    return name;    }

    public double getLvlScaling(){  return lvlScaling;  }

    public String getType(){    return type;    }
    
    public String getAbout(){   return about;   }

    public int getBaseHP() {    return baseHP;  }


}

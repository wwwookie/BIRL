package birl.Model;

public class Character {
    
    protected int id;
    protected double lvlScaling;
    protected String about;
    protected String type;  // TODO: make this enum
    protected String name;

    public Character(){}

    public Character(int id, String name, double lvlScaling, String type, String about){
        this.id = id;
        this.name = name;
        this.lvlScaling = lvlScaling;
        this.type = type;
        this.about = about;
    }

    public int getId(){ return id;  }

    public String getName(){    return name;    }

    public double getLvlScaling(){  return lvlScaling;  }

    public String getType(){    return type;    }
    
    public String getAbout(){   return about;   }


}

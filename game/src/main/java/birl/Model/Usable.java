package birl.Model;

public abstract class Usable {
    
    private int id;
    private String name;
    private int damage;
    private int heal;
    private String type;
    private Effect effect;

    public int getId(){ return id;  };

    public String getName(){    return name;    }

    public int getDamage(){ return damage;  }

    public int getHeal(){ return heal;  }

    public String getType(){ return type;  }

    public Effect getEffect(){ return effect;  }

}

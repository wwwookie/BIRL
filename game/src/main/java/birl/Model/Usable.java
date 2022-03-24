package birl.Model;

public abstract class Usable {
    
    protected int id;
    protected String name;
    protected int damage;
    protected int heal;
    protected String type;
    protected String effect;

    public Usable(int id, String name, int damage, int heal, String type, String effect){
        this.id = id;
        this.name = name;
        this.damage = damage;
        this.heal = heal;
        this.type = type;
        this.effect = effect;
    }

    public Usable(){}

    public int getId(){ return id;  };

    public String getName(){    return name;    }

    public int getDamage(){ return damage;  }

    public int getHeal(){ return heal;  }

    public String getType(){ return type;  }

    public String getEffect(){ return effect;  }

    public String toString(){
        return "ID: " + id + "\nName: " + name + "\nDamage: " + damage + "\nHeal: " + heal + "\nType: " + type + "\nEffect: " + effect;

    }
}

package birl;

public abstract class Usable {
    
    private int damage;
    private int heal;
    private Type type;
    private Effect effect;

    public int getDamage(){ return damage;  };

    public int getHeal(){ return heal;  };

    public Type getType(){ return type;  };

    public Effect getEffect(){ return effect;  };

}

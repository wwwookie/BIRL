package birl;

public class Fighter{

    private int id;
    private int lvl;
    private int hp;
    private double lvl_scaling;
    private Ability ability;
    private Type type;
    private String name;
    private Move [] moves = new Move[3];
    private Gear gear;
    private Team team;

    public Fighter(int id, int lvl, int hp, Team team) throws Exception{
        this.id = id;       // TODO: check if id is already existing in DB
        
        if(lvl > 0 || lvl < 101)
            this.lvl = lvl;
        else throw new Exception("Lvl must be greater than 0 and smaller than 101.");
        
        this.hp = hp;
        this.team = team;
    }

    public Move [] getMoves(){  return moves;   }

    public void setMove(Move move, int position) throws Exception{   
        if(type == move.getType())
            moves[position] = move;    
        else throw new Exception("Fighter can't learn move, type-missmatch.");
    }

    public void removeMove(int position){   moves[position] = null;    }

    public int getId(){ return id;  }

    public Gear getGear(){  return gear;   }

    public void setGear(Gear gear){   this.gear = gear;    }

    public void removeGear(int position){   moves[position] = null; }



}

package birl.Model;

public class Fighter extends Character{

    private int fighterId;
    private int lvl;
    private int hp;
    private Move [] moves = new Move[3];
    private Gear gear;

    public Fighter(int fighterId, int lvl, int hp, int characterId, String name, double lvlScaling, String type, String about) {
        super(characterId, name, lvlScaling, type, about);

        this.fighterId = fighterId;       // TODO: check if id is already existing in DB
        
        if(lvl > 0 || lvl < 101)
            this.lvl = lvl;
        else System.err.println("Lvl must be greater than 0 and smaller than 101.");

        this.hp = hp;
    }

    /** @return this fighters moves. */
    public Move [] getMoves(){  return moves;   }

    /** Fighter learns @param move as @param position move. 
     *  move-type must be equal to this fighters-type
    */
    public void setMove(Move move, int position) {   
        if(type.equals(move.getType()))
            moves[position] = move;    
        else System.err.println("Fighter can't learn move, type-missmatch.");
    }

    /** Removes move at @param position index. */
    public void removeMove(int position){   moves[position] = null;    }

    /** @return this fighters id. */
    public int getId(){ return id;  }

    /** @return this fighters equiped gear. */
    public Gear getGear(){  return gear;   }

    /** Euqips this fighter with @param gear. */
    public void setGear(Gear gear){   this.gear = gear;    }

    /** Unequips this fighters gear. */
    public void removeGear(){   gear = null; }
}

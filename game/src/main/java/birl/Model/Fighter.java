package birl.Model;

public class Fighter extends Character{

    private int fighterId;
    private int lvl;
    private int actualHP;
    private Move [] moves = new Move[3];
    private Gear gear;

    public Fighter(Character character) {
        
        this.id = character.getId();
        this.name = character.getName();
        this.baseHP = character.getBaseHP();
        this.lvlScaling = character.getLvlScaling();
        this.type = character.getType();
        this.about = character.getAbout();

        this.lvl = 1;
        this.actualHP = baseHP;

        //this.fighterId = fighterId;       // TODO: search for new unused id in db and set it as fighterId
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
    public int getFighterId(){ return fighterId;  }

    /** @return this fighters lvl */
    public int getLvl(){    return lvl; }

    /** @return this fighters actualHP */
    public int getActualHP(){   return actualHP;    }

    /** @return this fighters equiped gear. */
    public Gear getGear(){  return gear;   }

    /** Equips this fighter with @param gear. */
    public void setGear(Gear gear){   this.gear = gear;    }

    /** Unequips this fighters gear. */
    public void removeGear(){   gear = null; }

    /**
     * Manipulates this fighters actualHP.
     * @param value - hp will be de-/increased by this value
     * Negative values will decrease, positive values will increase.
     */
    public void manipulateHP(int value){

        // fighters can heal to a maximum of baseHP
        if(actualHP + value > baseHP)
            actualHP = baseHP;
        else actualHP += value;
    }

    /**
     * This fighter uses a move or a gear on the given target.
     * @param moveOrGear - from this fighters moves or gear
     * @param target - to be attacked fighter
     * @throws Exception - if move or gear not learnd
     */

    public void use(int moveOrGearID, Fighter target) throws Exception{

        if(moveOrGearID == gear.getId()){
            target.manipulateHP(-gear.getDamage());
            manipulateHP(gear.getHeal());
        } else if(moveOrGearID == moves[0].getId()){
            target.manipulateHP(-moves[0].getDamage());
            manipulateHP(moves[0].getHeal());
        } else if(moveOrGearID == moves[1].getId()){            // TODO: need to differentiate move and gear ids
            target.manipulateHP(-moves[1].getDamage());
            manipulateHP(moves[1].getHeal());
        } else if(moveOrGearID == moves[2].getId()){
            target.manipulateHP(-moves[2].getDamage());
            manipulateHP(moves[2].getHeal());
        } else throw new Exception("This fighter doesn't know this move or gear.");

        //TODO: print used move/gear to game's console
        // ... also make "effectivity" work

    }
}

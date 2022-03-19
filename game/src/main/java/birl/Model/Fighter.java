package birl.Model;

public class Fighter extends Character{

    private int fighterId;
    private int lvl;
    private int baseHP;
    private int actualHP;
    private Move [] moves = new Move[3];
    private Gear gear;

    public Fighter(int fighterId, int lvl, int baseHP, int characterId, String name, double lvlScaling, String type, String about) {
        super(characterId, name, lvlScaling, type, about);

        this.fighterId = fighterId;       // TODO: check if id is already existing in DB
        
        if(lvl > 0 || lvl < 101)
            this.lvl = lvl;
        else System.err.println("Lvl must be greater than 0 and smaller than 101.");

        this.baseHP = baseHP;
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
            target.manipulateHP(gear.getDamage());
            manipulateHP(gear.getHeal());
        } else if(moveOrGearID == moves[0].getId()){
            target.manipulateHP(moves[0].getDamage());
            manipulateHP(moves[0].getHeal());
        } else if(moveOrGearID == moves[1].getId()){
            target.manipulateHP(moves[1].getDamage());
            manipulateHP(moves[1].getHeal());
        } else if(moveOrGearID == moves[2].getId()){
            target.manipulateHP(moves[2].getDamage());
            manipulateHP(moves[2].getHeal());
        } else throw new Exception("This fighter doesn't know this move or gear.");

        //TODO: print used move/gear to game's console
        // ... also make "effectivity" work

    }
}

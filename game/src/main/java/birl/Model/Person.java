// this class will be needed in multiplayer mode, yet we only have singleplayer/local fights...

package birl.Model;

public class Person {
    
    private int id;
    private String username;
    private String password;
    private int victoryPoints;
    private int userLvl = 1;        // 1 = regular person, 2 = admin
    private Fighter[] team = new Fighter[5];

    public Person(String username, String password){
        // TODO: check for username twining!
        if(username == null
            || password == null)
            System.err.println("Every person must contain valid: username, password");
        else{
            this.username = username;
            this.password = password;
        }

        // TODO: create entry in person (db)
    }

    public void addAdminPrivilege(){   this.userLvl = 2;   }

    public void removeAdminPrivilege(){ this.userLvl = 1;   }

    public int getVictoryPoints(){  return victoryPoints;   }

    public void setVictoryPoints(int victoryPoints){    
        if(userLvl == 2)
            this.victoryPoints = victoryPoints;
        else {
            System.err.println("Only admins are allowed to set their victory points.");
            this.victoryPoints = 0;
        }
    }

    // should regular users be able to choose team? - will do these kind of restrictions later
    public void setTeam(Fighter[] team){  
        if(team != null)
            if(userLvl == 2)
                this.team = team;
            else System.err.println("Only admins are allowed to chose their team.");
        else System.err.println("This person's team is empty.");
    }

    public void addFighterToTeam(Fighter fighter){
        for(int i = 0; i < team.length; i++)
            if(team[i] == null){
                team[i] = fighter;
                i = team.length;
            }
    }

}

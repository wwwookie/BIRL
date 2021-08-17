package birl;

public class Person {
    
    private String username;
    private String password;
    private int victoryPoints;
    private int userLvl = 1;        // 1 = normal person, 2 = admin
    private Team team;

    public Person(String username, String password){
        if(username == null
            || password == null)
            System.err.println("Every person must contain valid: username, password and team");
        else{
            this.username = username;
            this.password = password;
        }
    }

    public void addAdminPrivilege(){   this.userLvl = 2;   }

    public void removeAdminPrivilege(){ this.userLvl = 1;   }

    public int getVictoryPoints(){  return victoryPoints;   }

    public void setVictoryPoints(int victoryPoints){    
        if(userLvl == 2)
            this.victoryPoints = victoryPoints;
        else System.err.println("Only admins are allowed to set their victory points.");
    }

    public void setTeam(Team team) throws Exception{  
        if(team != null)
            if(userLvl == 2)
                this.team = team;
            else System.err.println("Only admins are allowed to chose their team.");
        else System.err.println("This person's team is empty.");
    }

}

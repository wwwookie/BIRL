package birl.Model;

public class LocalFight {

    private Fighter[] teamRed = new Fighter[6];
    private Fighter[] teamBlue = new Fighter[6];

    public LocalFight(Fighter[] teamRed, Fighter[] teamBlue){
        this.teamRed = teamRed;
        this.teamBlue = teamBlue;
    }

    public void start(){

        // random number between 0 and 1
        int startingPlayer = (int)Math.floor(Math.random() * 2 + 0);
        boolean running = true;
        Fighter[] teamActive;
        Fighter[] teamPassive;

        if(startingPlayer == 0){
            teamActive = teamRed;
            teamPassive = teamBlue;
        }
        else {
            teamActive = teamBlue;
            teamPassive = teamRed;
        }

        // TODO: game loop - put game loop into mainFX?
        while(running){

            
        }

    }
    
}

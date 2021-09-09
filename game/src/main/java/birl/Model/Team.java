package birl.Model;

public class Team {
    
    private int id;
    private Person owner;
    private Fighter [] members = new Fighter[5];

    public Team(Person owner){
        this.owner = owner;
    }

    // do we need this doublebinding?
    //  -> Person already knows its team!
    public Team(Person owner, Fighter [] members) {
        this.owner = owner;
        this.members = members;
        owner.setTeam(this);
    }

    /** Add the fighter @param member to this team. */
    public void addFighter(Fighter member){
        int i = 0;
        
        while(members[i] != null)
            i++;
        
        members[i] = member;
    }

    /** Remove the fighter @param fighter from this team. */
    public void removeFighter(Fighter fighter){
        for(int i = 0; i < members.length; i++){
            if(members[i] != null)
                if(members[i].getId() == fighter.getId()){
                    members[i].removeTeamOfFighter();
                    members[i] = null;
                }
        }
    }

    public Fighter getFighter(int id){
        for(int i = 0; i < members.length; i++)
            if(members[i] != null)
                if(members[i].getId() == id)
                    return members[i];

        System.err.println("Could not find fighter with this ID");
        return null;
    }
}

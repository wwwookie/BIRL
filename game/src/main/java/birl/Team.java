package birl;

public class Team {
    
    private Person owner;
    private Fighter [] members = new Fighter[5];

    public Team(Person owner){
        this.owner = owner;
    }

    // do we need this doublebinding?
    //  -> Person already knows its team!
    public Team(Person owner, Fighter [] members) throws Exception{
        this.owner = owner;
        this.members = members;
        owner.setTeam(this);
    }

    public void addFighter(Fighter member){
        int i = 0;
        
        while(members[i] != null)
            i++;
        
        members[i] = member;
    }

    public void removeFighter(Fighter fighter){
        for(int i = 0; i < members.length; i++){
            if(members[i].getId() == fighter.getId())
                members[i] = null;
        }
    }
}

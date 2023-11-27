package cancionero.cancionero.domain;

public class Notes {
    
    private String noteName;

    public Notes(String noteName){
        this.noteName = noteName;
    }

    public String getNoteName(){
        return this.noteName;    
    }
    public void setNoteName(String noteName){
        this.noteName = noteName;
    }
}



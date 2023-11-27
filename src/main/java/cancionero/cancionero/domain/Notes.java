package cancionero.cancionero.domain;

public class Notes {
    
    private String noteName;

    public Notes(String noteName){
        this.noteName = noteName;
    }

    private String getNoteName(){
        return this.noteName;    
    }
    private void setNoteName(String noteName){
        this.noteName = noteName;
    }
}



package cancionero.cancionero.domain;

import java.util.ArrayList;
import java.util.List;

public class Chord {

    private String chordName;
    private List<Notes> notesList;

    public Chord (String chordName){
        this.chordName = chordName;
        this.notesList = new ArrayList<Notes>();
    }

    public String getChordName(){
        return this.chordName;
    }
    public List<Notes> getNotesList(){
        return this.notesList;
    }
    public void setChordName(String chordName){
        this.chordName = chordName;
    }
    public void setNotesList(List<Notes> notesList){
        this.notesList = notesList;
    }    
}

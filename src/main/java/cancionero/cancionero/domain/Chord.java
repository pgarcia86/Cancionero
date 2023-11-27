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

    private String getChordName(){
        return this.chordName;
    }
    private List<Notes> getNotesList(){
        return this.notesList;
    }
    private void setChordName(String chordName){
        this.chordName = chordName;
    }
    private void setNotesList(List<Notes> notesList){
        this.notesList = notesList;
    }    
}

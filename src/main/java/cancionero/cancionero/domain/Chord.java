package cancionero.cancionero.domain;

import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Chord {

    private String chordName;
    private List<Notes> notesList;

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

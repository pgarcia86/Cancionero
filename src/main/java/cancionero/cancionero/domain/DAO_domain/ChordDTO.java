package cancionero.cancionero.domain.DAO_domain;

import cancionero.cancionero.domain.Notes;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ChordDTO {

    private String chordName;
    private List <Notes> notesList;
    
}

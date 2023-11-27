package cancionero.cancionero.domain.DAO_domain;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import cancionero.cancionero.domain.Chord;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class SongDTO {

    private Integer songId;
    private String songName;
    private String singerName;
    private List<Chord> chordList;
    private String tonality;
}

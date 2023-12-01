package cancionero.cancionero.repository;

import java.util.List;

import cancionero.cancionero.domain.Chord;
import cancionero.cancionero.domain.Song;

public interface CustomSongRepositoy {

    List<Song> getSongsByChordQuantity(Integer chordQuantity);
    List<Song> getSongsByChordQuantityMaxMin(Integer max, Integer min);
    String editChordList(Integer songId, List<Chord> chordList);
    String editSongTonalityById(Integer songId, String songTonality);
    
}

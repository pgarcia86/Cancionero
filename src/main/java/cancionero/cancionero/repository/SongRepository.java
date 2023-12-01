package cancionero.cancionero.repository;

import java.util.List;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import cancionero.cancionero.domain.Chord;
import cancionero.cancionero.domain.Song;

@Repository
public interface SongRepository extends MongoRepository<Song, Integer>{
    
    List<Song> findAll();
    List<Song> getSongsByTonality(String tonality);
    List<Song> getTonalityBySongName(String songName);
    List<Song> getSongBySingerName(String singerName);

    Song getSongBySongName(String songName);
    Song getSongBySongId(Integer id);

    List<Chord> getChordsListBySongName(String songName);
    List<Chord> getChordListBySongId(Integer id);
    
}

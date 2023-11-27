package cancionero.cancionero.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import cancionero.cancionero.domain.Chord;
import cancionero.cancionero.domain.Song;

@Repository
public interface SongRepository extends MongoRepository<Song, Integer>{
    
    List<Song> getSongsList();
    List<Song> getSongsByTonality(String tonality);
    List<Song> getTonalityBySongName(String name);
    List<Song> getSongBySinger(String singerName);

    Song getSongByName(String name);
    Song getSongById(Integer id);

    List<Chord> getChordsListBySongName(String songName);
    List<Chord> getChordListBySongId(Integer id);
    
    
}

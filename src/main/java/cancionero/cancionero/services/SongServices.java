package cancionero.cancionero.services;

import java.util.List;
import org.springframework.stereotype.Service;
import cancionero.cancionero.domain.Chord;
import cancionero.cancionero.domain.Song;
import cancionero.cancionero.domain.DAO_domain.SongDTO;

@Service
public interface SongServices {

    public SongDTO addNewSong(Song newSong);

    public boolean existSongBySongId(Integer songId);

    public List<SongDTO> getSongsList();
    public List<SongDTO> getSongsByTonality(String tonality);
    public List<SongDTO> getSongsBySinger(String singerName);
    public List<SongDTO> getSongByChordQuantity(Integer chordQuantity);
    public List<SongDTO> getSongByChordQuantityMaxMin(Integer max, Integer min);
  
    public SongDTO getSongByName(String songName);
    public SongDTO getSongById(Integer songId);

    public String editChordList(Integer songId, List<Chord> chordList);
    public String editSongTonalityById(Integer songId, String songTonality);

    public String getTonalityBySongName(String songName);

    public List<Chord> getChordsListBySongName(String songName);

    public void deleteSongById(Integer songId);
    public void deleteSongBySongName(String songName);
    public void deleteSongsBySingerName(String singerName);    
}

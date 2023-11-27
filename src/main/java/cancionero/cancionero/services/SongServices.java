package cancionero.cancionero.services;

import java.util.List;

import org.springframework.stereotype.Service;
import cancionero.cancionero.domain.DAO_domain.ChordDTO;
import cancionero.cancionero.domain.DAO_domain.SongDTO;

@Service
public interface SongServices {

    public List<SongDTO> getSongList();
    public List<SongDTO> getSongsByTonality(String tonality);
    public List<SongDTO> getSongsBySinger(String singerName);
    
    public SongDTO getSongByName(String name);
    public SongDTO getSongById(Integer id);
    
    public String getTonalityBySongName(String songName);

    public List<ChordDTO> getChordsList();
    public String getTonality();

}
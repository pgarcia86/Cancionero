package cancionero.cancionero.repository.implementation;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import cancionero.cancionero.domain.Chord;
import cancionero.cancionero.domain.Song;
import cancionero.cancionero.repository.CustomSongRepositoy;
import cancionero.cancionero.repository.SongRepository;

@Repository
public class CustomSongRepositoryImpl implements CustomSongRepositoy{

    @Autowired 
    SongRepository songRepository;

    //Con este metodo devuelvo las canciones con la cantidad de acordes pasado por parametro
    @Override
    public List<Song> getSongsByChordQuantity(Integer chordQuantity) {  
        List<Song> songsList = songRepository.findAll();
        List<Song> songsListByChord = new ArrayList<Song>();
        for(Song song : songsList){
            if(song.getChordList().size() == chordQuantity){
                songsListByChord.add(song);
            }
        }
        return songsListByChord;
    }

    @Override
    public String editChordList(Integer id, List<Chord> chordList) {
        if (songRepository.existsById(id)) {
            Song song = songRepository.getSongBySongId(id);
            song.setChordList(chordList);
            songRepository.save(song);
            return "Se editó la lista de acordes";
            }
        return "No existe la cancion";
        }

    @Override
    public List<Song> getSongsByChordQuantityMaxMin(Integer max, Integer min) {
        List<Song> songsList = songRepository.findAll();
        List<Song> songsListByChord = new ArrayList<Song>();
        for(Song song : songsList){
            if(song.getChordList().size() >= min && song.getChordList().size() <= max){
                songsListByChord.add(song);
            }
        }
        return songsListByChord;
    }

    @Override
    public String editSongTonalityById(Integer songId, String songTonality) {
        if (songRepository.existsById(songId)) {
            Song song = songRepository.getSongBySongId(songId);
            song.setTonality(songTonality);
            songRepository.save(song);
            return "Se editó la tonalidad de la cancion";
        }
        return "No existe la cancion";
    }    
}

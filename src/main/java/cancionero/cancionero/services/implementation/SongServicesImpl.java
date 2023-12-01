package cancionero.cancionero.services.implementation;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import cancionero.cancionero.domain.Chord;
import cancionero.cancionero.domain.Song;
import cancionero.cancionero.domain.DAO_domain.SongDTO;
import cancionero.cancionero.repository.SongRepository;
import cancionero.cancionero.repository.implementation.CustomSongRepositoryImpl;
import cancionero.cancionero.services.SongServices;
import java.util.ArrayList;

@Service
public class SongServicesImpl implements SongServices{

    @Autowired SongRepository songRepository;
    @Autowired CustomSongRepositoryImpl customSongRepository; 

    @Override
    public SongDTO addNewSong(Song newSong) {
        Song song = new Song(newSong.getSongId(), newSong.getSongName(), newSong.getChordList(), newSong.getTonality(), newSong.getSingerName());
        songRepository.save(song);
        return returnSongDTO(song);
    }

    @Override
    public boolean existSongBySongId(Integer id) {
        if (songRepository.existsById(id)){
            return true;
        }
        return false;
    }

    @Override
    public List<SongDTO> getSongsList() {
        List<Song> songsList = songRepository.findAll();
        List<SongDTO> songDtos = new ArrayList<SongDTO>();
        for (Song song : songsList){
            System.out.println(song);
            songDtos.add(returnSongDTO(song));
        }
        return songDtos;            
    }

    @Override
    public List<SongDTO> getSongsByTonality(String tonality) {
        List<Song> songsList = songRepository.getSongsByTonality(tonality);
        List<SongDTO> songDTOList = new ArrayList<SongDTO>();
        for(Song song : songsList){
            songDTOList.add(returnSongDTO(song));
        }
        return songDTOList;
    }

    @Override
    public List<SongDTO> getSongsBySinger(String singerName) {
        List<Song> songsList = songRepository.getSongBySingerName(singerName);
        List<SongDTO> songDTOList = new ArrayList<SongDTO>();
        for(Song song : songsList){
            songDTOList.add(returnSongDTO(song));
        }
        return songDTOList;
    }

    @Override
    public List<SongDTO> getSongByChordQuantity(Integer chordQuantity) {
        List<Song> songsList = customSongRepository.getSongsByChordQuantity(chordQuantity);
        List<SongDTO> songListDTO = new ArrayList<SongDTO>();
        for(Song song : songsList){
            songListDTO.add(returnSongDTO(song));
        }
        return songListDTO;
    }

    @Override
    public List<SongDTO> getSongByChordQuantityMaxMin(Integer max, Integer min) {
        List<Song> songsList = customSongRepository.getSongsByChordQuantityMaxMin(max, min);
        List<SongDTO> songListDTO = new ArrayList<SongDTO>();
        for(Song song : songsList){
            songListDTO.add(returnSongDTO(song));
        }
        songListDTO.sort(null);
        return songListDTO;
    }

    @Override
    public String editChordList(Integer id, List<Chord> chordList) {
        customSongRepository.editChordList(id, chordList);
        return "Se edito la lista de canciones";
    } 
    
    @Override
    public String editSongTonalityById(Integer songId, String songTonality) {
        customSongRepository.editSongTonalityById(songId, songTonality);
        return "Se editó la tonalidad";
    }

    @Override
    public String getTonalityBySongName(String songName){
        Song songByName = songRepository.getSongBySongName(songName);
        return songByName.getTonality();
    }

    @Override
    public SongDTO getSongByName(String songName) {
        Song songByName = songRepository.getSongBySongName(songName);
        System.out.println(songByName);
        return returnSongDTO(songByName);        
    }

    @Override
    public SongDTO getSongById(Integer id) {
        Song songById = songRepository.getSongBySongId(id);
        return returnSongDTO(songById);
    }

    @Override
    public List<Chord> getChordsListBySongName(String songName) {
        SongDTO songDTO = returnSongDTO(songRepository.getSongBySongName(songName));
        return songDTO.getChordList();
    }

    @Override
    public void deleteSongById(Integer id) {
        songRepository.deleteById(id);
    }

    @Override
    public void deleteSongBySongName(String name) {
        songRepository.deleteById(songRepository.getSongBySongName(name).getSongId());
    }

    @Override
    public void deleteSongsBySingerName(String singerName) {
        songRepository.getSongBySingerName(singerName).forEach(song -> {songRepository.deleteById(song.getSongId());});
    }

    public SongDTO returnSongDTO(Song song) {
        SongDTO songDTO = new SongDTO();
        songDTO.setSongId(song.getSongId());
        songDTO.setSingerName(song.getSingerName());
        songDTO.setSongName(song.getSongName());
        songDTO.setTonality(song.getTonality());
        songDTO.setChordList(song.getChordList());
        return songDTO;
    }

}

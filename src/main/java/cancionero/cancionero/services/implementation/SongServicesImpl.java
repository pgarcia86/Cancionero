package cancionero.cancionero.services.implementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import cancionero.cancionero.domain.Song;
import cancionero.cancionero.domain.DAO_domain.ChordDTO;
import cancionero.cancionero.domain.DAO_domain.SongDTO;
import cancionero.cancionero.repository.SongRepository;
import cancionero.cancionero.services.SongServices;
import java.util.ArrayList;

@Service
public class SongServicesImpl implements SongServices{

    @Autowired SongRepository songRepository;

    @Override
    public List<SongDTO> getSongList() {
        List<Song> songsList = songRepository.findAll();
        List<SongDTO> songDtos = new ArrayList<SongDTO>();
        for (Song song : songsList){
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
        List<Song> songsList = songRepository.getSongBySinger(singerName);
        List<SongDTO> songDTOList = new ArrayList<SongDTO>();
        for(Song song : songsList){
            songDTOList.add(returnSongDTO(song));
        }
        return songDTOList;
    }

    @Override
    public String getTonalityBySongName(String songName){
        Song songByName = songRepository.getSongByName(songName);
        return songByName.getTonality();
    }

    @Override
    public SongDTO getSongByName(String songName) {
        Song songByName = songRepository.getSongByName(songName);
        return returnSongDTO(songByName);        
    }

    @Override
    public SongDTO getSongById(Integer id) {
        Song songById = songRepository.getSongById(id);
        return returnSongDTO(songById);
    }


    @Override
    public List<ChordDTO> getChordsList() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getChordsList'");
    }

    @Override
    public String getTonality() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getTonality'");
    }



    public SongDTO returnSongDTO(Song song) {

        SongDTO songDTO = new SongDTO();
        songDTO.setSongId(song.getSongId());
        songDTO.setSongName(song.getSongName());
        songDTO.setTonality(song.getTonality());
        songDTO.setChordList(song.getChordList());
        return songDTO;

    }




}

package cancionero.cancionero.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import cancionero.cancionero.domain.Chord;
import cancionero.cancionero.domain.Song;
import cancionero.cancionero.domain.DAO_domain.SongDTO;
import cancionero.cancionero.services.implementation.SongServicesImpl;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class SongController {

    @Autowired
    private SongServicesImpl songServices;

    //Obtengo todas las canciones y las ordeno por ID de menor a mayor
    @GetMapping(value = "/allSongs/MinMax")
    private ResponseEntity<List<SongDTO>> getAllSongsMinMax(){
        List<SongDTO> songsListDTO = songServices.getSongsList();
        songsListDTO.sort(Comparator.comparing(SongDTO :: getSongId));
        return new ResponseEntity<List<SongDTO>>(songsListDTO, HttpStatus.OK);
   }

    //Obtengo todas las canciones y las ordeno por ID de mayor a menor
    @GetMapping(value = "/allSongs/MaxMin")
    private ResponseEntity<List<SongDTO>> getAllSongsMaxMin(){
        List<SongDTO> songsListDTO = songServices.getSongsList();
        songsListDTO.sort(Comparator.comparing(SongDTO :: getSongId));
        Collections.reverse(songsListDTO);
        return new ResponseEntity<List<SongDTO>>(songsListDTO, HttpStatus.OK);
   }

    //Obtengo la cancion por el ID
   @GetMapping(value = "/song/id={id}")
   private ResponseEntity<SongDTO> getSongById(@PathVariable("id") Integer id){
        return new ResponseEntity<SongDTO>(songServices.getSongById(id), HttpStatus.OK);
   }

   //Obtengo la cancion por el nombre
   @GetMapping(value = "/song/name={songName}")
   private ResponseEntity<SongDTO> getSongBySongName(@PathVariable("songName") String songName){
        return new ResponseEntity<SongDTO>(songServices.getSongByName(songName), HttpStatus.OK);
   }

   //Obtengo las canciones por nombre del artista
   @GetMapping(value = "song/artist={artistName}")
   private ResponseEntity<List<SongDTO>> getSongByArtistName(@PathVariable("artistName") String artistName){
        return new ResponseEntity<List<SongDTO>>(songServices.getSongsBySinger(artistName), HttpStatus.OK);
   }

   //Obtengo las canciones por la tonalidad
   @GetMapping(value = "song/tonality={tonality}")
   private ResponseEntity<List<SongDTO>> getSongByTonality(@PathVariable("tonality") String tonality){
        return new ResponseEntity<List<SongDTO>>(songServices.getSongsByTonality(tonality), HttpStatus.OK);
   }

   //Obtengo las canciones por cantidad de acordes
   @GetMapping(value = "song/chords={chordQuantity}")
   private ResponseEntity<List<SongDTO>> getSongsByChordsQuantity(@PathVariable("chordQuantity") Integer chordQuantity){
        return new ResponseEntity<List<SongDTO>>(songServices.getSongByChordQuantity(chordQuantity), HttpStatus.OK);
   }

   //Obtengo las canciones por cantidad de acordes con un minimo y un maximo
   @GetMapping(value = "song/chords/max={max}/min={min}")
   private ResponseEntity<List<SongDTO>> getSongsByChordsQuantityMaxMin(@PathVariable("max") Integer max, @PathVariable("min") Integer min){
        List<SongDTO> songListDTO = songServices.getSongByChordQuantityMaxMin(max, min);
        songListDTO.sort(Comparator.comparing(s -> s.getChordList().size()));
        return new ResponseEntity<List<SongDTO>>(songServices.getSongByChordQuantityMaxMin(max, min), HttpStatus.OK);
   }

   //Obtengo la tonalidad por el ID de la cancion
   @GetMapping(value = "/song/tonality/id={id}")
   private ResponseEntity<String> getTonalityBySongId(@PathVariable("id") Integer songId){
        return new ResponseEntity<String>("La tonalidad de " + songId + " es " + songServices.getTonalityBySongName(songServices.getSongById(songId).getSongName()), HttpStatus.OK);
   }

    //Obtengo la tonalidad por el nombre de la cancion
   @GetMapping(value = "/song/tonality/name={songName}")
   private ResponseEntity<String> getTonalityBySongName(@PathVariable("songName") String songName){
        return new ResponseEntity<String>("La tonalidad de " + songName + " es " + songServices.getTonalityBySongName(songName), HttpStatus.OK);
   }

    //Obtengo la lista de acordes de la cancion por ID
   @GetMapping(value = "song/chordList/id={songId}")
   private ResponseEntity<List<Chord>> getChordListBySongId(@PathVariable("songId") Integer songId){
        return new ResponseEntity<List<Chord>>(songServices.getChordsListBySongName(songServices.getSongById(songId).getSongName()), HttpStatus.OK);
   }

   //Obtengo la lista de acordes de la cancion por nombre
   @GetMapping(value = "song/chordList/name={songName}")
   private ResponseEntity<List<Chord>> getChordListBySongName(@PathVariable("songName") String songName){
        return new ResponseEntity<List<Chord>>(songServices.getChordsListBySongName(songName), HttpStatus.OK);
   }

    //Añado una nueva cancion
    @PostMapping(value = "/newSong")
    private ResponseEntity<String> postNewSong(@RequestBody Song song){
        if(songServices.existSongBySongId(song.getSongId())){            
            return new ResponseEntity<String>("Ya existe la canción con el ID ingresado", HttpStatus.BAD_REQUEST);
        }
        songServices.addNewSong(song);
        return new ResponseEntity<String>("Se insertó la cancion correctamente", HttpStatus.CREATED);      
    }    

    //Edito la lista de acordes de la cancion por ID
    @PutMapping(value = "/song/chordList/id={id}")
    private ResponseEntity<String> editChordList(@PathVariable("id") Integer id, @RequestBody List<Chord> chordList){
        songServices.editChordList(id, chordList);
        return new ResponseEntity<String>("OK", HttpStatus.OK);
    }

    //Edito la tonalidad de la cancion por el ID
    @PutMapping(value = "/song/tonality/id={id}/newTonality={songTonality}")
    private ResponseEntity<String> editTonality(@PathVariable("id") Integer id, @PathVariable("songTonality") String songTonality){
        songServices.editSongTonalityById(id, songTonality);
        return new ResponseEntity<String>("OK", HttpStatus.OK);
    }

    //Edito la tonalidad de la cancion por el nombre de la cancion
    @PutMapping(value = "/song/tonality/songName={songName}/newTonality={songTonality}")
    private ResponseEntity<String> editTonality(@PathVariable("songName") String songName, @PathVariable("songTonality") String songTonality){
        songServices.editSongTonalityById(songServices.getSongByName(songName).getSongId(), songTonality);
        return new ResponseEntity<String>("OK", HttpStatus.OK);
    }

    //Edito la lista de acordes de la cancion por el nombre de la cancion
    @PutMapping(value = "/song/chordList/songName={songName}")
    private ResponseEntity<String> editChordListBySongName(@PathVariable("songName") String songName, @RequestBody List<Chord> chordList){
        songServices.editChordList(songServices.getSongByName(songName).getSongId(), chordList);
        return new ResponseEntity<String>("OK", HttpStatus.OK);
    }

    //Edito la lista de acordes de la cancion por el ID de la cancion
    @PutMapping(value = "/song/chordList/songId={songId}")
    private ResponseEntity<String> editChordListBySongId(@PathVariable("songId") Integer songId, @RequestBody List<Chord> chordList){
        songServices.editChordList(songServices.getSongByName(songServices.getSongById(songId).getSongName()).getSongId(), chordList);
        return new ResponseEntity<String>("OK", HttpStatus.OK);
    }

    //Elimino una cancion por ID
    @DeleteMapping(value = "song/delete/id={id}")
    private ResponseEntity<String> deleteSongById(@PathVariable("id") Integer id){
        songServices.deleteSongById(id);
        return new ResponseEntity<String>("Se eliminó la canción con ID: " + id, HttpStatus.OK);
    }

    //Elimino una cancion por su nombre
    @DeleteMapping(value = "song/delete/name={songName}")
    private ResponseEntity<String> deleteSongBySongName(@PathVariable("songName") String songName){
        songServices.deleteSongBySongName(songName);
        return new ResponseEntity<String>("Se eliminó la canción con nombre: " + songName, HttpStatus.OK);
    }

    //Elimino canciones por el nombre del artista
    @DeleteMapping(value = "song/delete/singerName={singerName}")
    private ResponseEntity<String> deleteSongsBySingerName(@PathVariable("singerName") String singerName){
        songServices.deleteSongsBySingerName(singerName);
        return new ResponseEntity<String>("Se eliminaron las canciones del artista: " + singerName, HttpStatus.OK);
    }
}

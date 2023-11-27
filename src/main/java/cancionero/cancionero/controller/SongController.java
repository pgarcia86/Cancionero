package cancionero.cancionero.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import java.util.List;
import cancionero.cancionero.domain.Song;
import cancionero.cancionero.domain.DAO_domain.SongDTO;
import cancionero.cancionero.services.implementation.SongServicesImpl;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class SongController {

    @Autowired
    private SongServicesImpl songServices;

    //Obtengo todas las canciones
    @GetMapping(value = "/allSongs")
    private ResponseEntity<List<SongDTO>> getAllSongs(){
        return new ResponseEntity<List<SongDTO>>(songServices.getSongsList(), HttpStatus.OK);
   }

    //Añado una nueva cancion
    @PostMapping(value = "/newSong")
    private ResponseEntity<String> postNewSong(@RequestBody Song song){
        if(songServices.existSongBySongId(song.getSongId())){            
            return new ResponseEntity<>("El usuario ya existe", HttpStatus.BAD_REQUEST);
        }
        songServices.addNewSong(song);
        return new ResponseEntity<String>("Se insertó la cancion correctamente", HttpStatus.CREATED);      
    }    

    //PutMapping para cambiar el nombre o algun parametro de la cancion

    //DeleteMapping para eliminar alguna cancion

    //GetMapping para obtener las canciones por cantidad de acordes

    //GetMapping para obtener las canciones por tonalidad

    //GetMapping para obtener las canciones por artista
}

package cancionero.cancionero.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import java.util.List;

import cancionero.cancionero.domain.Song;
import cancionero.cancionero.services.SongServices;
import cancionero.cancionero.services.implementation.SongServicesImpl;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class SongController {

    @Autowired
    private SongServicesImpl songServices;

    @GetMapping(value="/Song")
    private ResponseEntity<List<Song>> getAllSongs() {
        return new ResponseEntity<List<Song>>(songServices.getSongList(), HttpStatus.OK);
    }
    

    
}

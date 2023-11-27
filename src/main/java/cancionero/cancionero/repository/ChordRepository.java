package cancionero.cancionero.repository;

import java.util.List;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import cancionero.cancionero.domain.Chord;
import cancionero.cancionero.domain.Notes;

@Repository
public interface ChordRepository extends MongoRepository<Chord, Integer>{
    
    String getChordName();
    List<Notes> getNotesList();
}

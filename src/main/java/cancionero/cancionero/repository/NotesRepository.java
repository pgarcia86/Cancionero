package cancionero.cancionero.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import cancionero.cancionero.domain.Notes;

@Repository
public interface NotesRepository extends MongoRepository<Notes, Integer>{
    String getNoteName();
}

package com.cityjokes.backend.repositories;

import com.cityjokes.backend.domain.Joke;
import java.util.List;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author lilit
 */
@Repository
public interface JokeRepository extends MongoRepository<Joke, String> {

    List<Joke> findBySetupContainingOrPunchlineContaining(String inputSetup, String inputPunchline);
    List<Joke> findAllByTypeAndSetupContainingOrPunchlineContaining(String type, String inputSetup, String inputPunchline);
}

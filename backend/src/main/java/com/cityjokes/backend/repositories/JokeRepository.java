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

    Joke findByType(String type);
    List<Joke> findBySetupContaining(String inputText);
}

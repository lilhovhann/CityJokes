package com.cityjokes.backend.services;

import com.cityjokes.backend.domain.Joke;
import com.cityjokes.backend.repositories.JokeRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

/**
 *
 * @author lilit
 */
@Service
@Slf4j
public class JokeService {

    @Autowired
    private JokeRepository jokeRepo;

    public List<Joke> findBySearchInput(String searchInput){
        List<Joke> foundJokes = jokeRepo.findBySetup(searchInput);
        return foundJokes;
    }
    
    
    public Joke findByType(String type){
        Joke foundJoke = jokeRepo.findByType(type);
        return foundJoke;
    }
   
    public  List<Joke> findAll(){
        List<Joke> foundJoke = jokeRepo.findAll();
        return foundJoke;
    }
    
    
    public Optional<Joke> createJoke(Joke joke) {
        final Joke savedJoke = jokeRepo.save(joke);
        return Optional.ofNullable(savedJoke);
    }

}

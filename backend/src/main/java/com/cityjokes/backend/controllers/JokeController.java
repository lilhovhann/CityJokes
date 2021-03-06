package com.cityjokes.backend.controllers;

import com.cityjokes.domain.Joke;
import com.cityjokes.backend.services.JokeService;
import com.cityjokes.response.JokeApiResponse;
import java.io.IOException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;
import java.util.Optional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author lilit
 */
@RestController
@RequestMapping("/api/v2/jokes")
@Slf4j
public class JokeController {

    @Autowired
    private JokeService jokeService;

    @PostMapping(path = "/creation", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> create(@RequestBody Joke joke) {
        log.info("Create joke " + joke.toString());

        Optional<Joke> savedJoke = jokeService.createJoke(joke);
        return ResponseEntity.status(HttpStatus.OK).body(savedJoke.get());
    }

    @GetMapping(path = "/joke/findByKey", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    @CrossOrigin
    @Transactional
    public ResponseEntity<?> findByKey(@RequestParam(required = true) String searchKey) {
        List<Joke> foundJokes = jokeService.findBySearchInput(searchKey);
        JokeApiResponse response = new JokeApiResponse();
        if (!foundJokes.isEmpty()) {
            log.info("Here they are");
            response.getJokeList().addAll(foundJokes);
            return ResponseEntity.status(HttpStatus.OK).body(response);
        }

        log.error("Did not find any jokes");
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Did not find any jokes");
    }

    @GetMapping(path = "/joke/findAll", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    @CrossOrigin
    @Transactional
    public ResponseEntity<?> findAll() {
        List<Joke> foundJokes = jokeService.findAll();
        if (!foundJokes.isEmpty()) {
            log.info("There are no jokes with that search key");
            return ResponseEntity.status(HttpStatus.OK).body(foundJokes);
        }

        log.error("Did not find any jokes");
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Did not find any jokes");
    }

    @GetMapping(path = "/joke/findByType", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    @CrossOrigin
    @Transactional
    public ResponseEntity<?> findByType(@RequestParam(name = "type") String type, 
                                        @RequestParam(name = "input") String input) {
        List<Joke> foundJokes = jokeService.findByTypeAndKey(type, input);
        if (!foundJokes.isEmpty()) {
            log.info("Here");
            return ResponseEntity.status(HttpStatus.OK).body(foundJokes);
        }

        log.error("Did not find any jokes");
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Did not find any jokes");
    }

    @GetMapping(path = "/joke/pullJokes", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    @CrossOrigin
    @Transactional
    public ResponseEntity<?> pullJokes() throws IOException {
        Joke foundJokes = jokeService.pullJokes();

        return ResponseEntity.status(HttpStatus.OK).body("Joke: " + foundJokes);
    }

}

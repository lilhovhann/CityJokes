package com.cityjokes.backend.services;

import com.cityjokes.backend.domain.Joke;
import com.cityjokes.backend.repositories.JokeRepository;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
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

    public List<Joke> findBySearchInput(String searchInput) {
        List<Joke> foundJokes = jokeRepo.findBySetup(searchInput);
        return foundJokes;
    }

    public Joke findByType(String type) {
        Joke foundJoke = jokeRepo.findByType(type);
        return foundJoke;
    }

    public List<Joke> findAll() {
        List<Joke> foundJoke = jokeRepo.findAll();
        return foundJoke;
    }

    public Optional<Joke> createJoke(Joke joke) {
        final Joke savedJoke = jokeRepo.save(joke);
        return Optional.ofNullable(savedJoke);
    }

    public StringBuffer pullJokes() throws MalformedURLException, IOException {

        URL url = new URL("https://official-joke-api.appspot.com/jokes/random");
        HttpURLConnection con = (HttpURLConnection) url.openConnection();
        con.setRequestMethod("GET");
        con.setRequestProperty("Content-Type", "application/json");

        BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
        String inputLine;
        StringBuffer content = new StringBuffer();
        while ((inputLine = in.readLine()) != null) {
            content.append(inputLine);
        }
        in.close();
        con.disconnect();

        return content;

    }
}

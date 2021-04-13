package com.cityjokes.beans;

import java.io.Serializable;
import javax.inject.Named;
import javax.faces.view.ViewScoped;

import com.cityjokes.domain.Joke;

import com.cityjokes.clients.JokeClient;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;

import javax.inject.Inject;
import org.apache.log4j.Logger;

/**
 *
 * @author lilith
 */
@Named(value = "jokebean")
@ViewScoped
public class JokeBean implements Serializable {

    private static final Logger log = Logger.getLogger(JokeBean.class);

    @Inject
    private JokeClient jokeClient;

    private String searchKey;
    private String wholeJoke;

    private List<String> jokes;

    private Joke joke = new Joke();
    private List<Joke> searchedJokes = new ArrayList<>();

    public JokeBean() {
    }

    @PostConstruct
    public void init() {
        System.out.println("Start init");
        jokes = new ArrayList<>();
    }

    public List<String> doSearch() {
        log.info("Start search");
        jokes = new ArrayList<>();

        searchedJokes = jokeClient.getJokes(searchKey).getJokeList();
        for (Joke item : searchedJokes) {
            wholeJoke = item.getSetup() +" "+ item.getPunchline();
            jokes.add(wholeJoke);
        }

        return jokes;
    }

    public List<Joke> getSearchedJokes() {
        return searchedJokes;
    }

    public void setSearchedJokes(List<Joke> searchedJokes) {
        this.searchedJokes = searchedJokes;
    }

    public String getSearchKey() {
        return searchKey;
    }

    public void setSearchKey(String searchKey) {
        this.searchKey = searchKey;
    }

    public String getWholeJoke() {
        return wholeJoke;
    }

    public List<String> getJokes() {
        return jokes;
    }

}

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

    private Joke joke = new Joke();
    private List<Joke> searchedJokes = new ArrayList<>();

    public JokeBean() {
    }
    
        @PostConstruct 
    public void init() {
     System.out.println("Start init");
    }

    public List<Joke> doSearch() {
        log.info("Start search");
        
        searchedJokes = jokeClient.getJokes(searchKey).getJokeList();
        log.info("================Jokes are" +searchedJokes);
        return searchedJokes;
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
    
    

  

}

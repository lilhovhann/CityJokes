package com.cityjokes.response;

import com.cityjokes.domain.Joke;
import java.util.ArrayList;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 *
 * @author lilith
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class JokeApiResponse {
    
    
     List<Joke> jokeList  = new ArrayList<>();
     Joke joke = new Joke();
    
}

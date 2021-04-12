package com.cityjokes.backend.domain;

import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@EqualsAndHashCode

@Document(collection = "joke")
public class Joke implements Serializable {

    private int id;
    
    private String type;
    
    private String setup;
    
    private String punchline;
}

package com.cityjokes.clients;

import com.cityjokes.response.JokeApiResponse;
import com.cityjokes.util.GsonConverter;
import java.io.IOException;
import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.apache.log4j.Logger;

@Named
@ApplicationScoped
public class JokeClient implements Serializable {

    private static final long serialVersionUID = 1L;
    private static final Logger LOG = Logger.getLogger(JokeClient.class);

    public JokeClient() {
    }

    @PostConstruct
    public void init() {
        LOG.debug("JokeClient called");
    }

    public JokeApiResponse getJokes(String searchKey) {
        JokeApiResponse model = new JokeApiResponse();
        long startTime = System.currentTimeMillis();
        try ( CloseableHttpClient httpClient = HttpClients.createDefault()) {
            HttpGet request = new HttpGet("http://localhost:8080/api/v2/jokes/joke/findByKey?searchKey=" + searchKey);
            request.addHeader("content-type", "application/json;charset=UTF-8");
            request.addHeader("charset", "UTF-8");
            CloseableHttpResponse response = httpClient.execute(request);
            try ( CloseableHttpResponse httpResponse = httpClient.execute(request)) {
                model = GsonConverter.fromJson(EntityUtils.toString(httpResponse.getEntity()), JokeApiResponse.class);
            }
            long elapsedTime = System.currentTimeMillis() - startTime;

        } catch (IOException e) {

        }
        return model;
    }
    
      public JokeApiResponse getJokesByType(String type, String input) {
        JokeApiResponse model = new JokeApiResponse();
        long startTime = System.currentTimeMillis();
        try ( CloseableHttpClient httpClient = HttpClients.createDefault()) {
            HttpGet request = new HttpGet("http://localhost:8080/api/v2/jokes/joke/findByType?type=" + type+"&input="+input);
            request.addHeader("content-type", "application/json;charset=UTF-8");
            request.addHeader("charset", "UTF-8");
            CloseableHttpResponse response = httpClient.execute(request);
            try ( CloseableHttpResponse httpResponse = httpClient.execute(request)) {
                model = GsonConverter.fromJson(EntityUtils.toString(httpResponse.getEntity()), JokeApiResponse.class);
            }
            long elapsedTime = System.currentTimeMillis() - startTime;

        } catch (IOException e) {

        }
        return model;
    }

}

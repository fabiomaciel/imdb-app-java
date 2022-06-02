package br.com.fabio.imdbappjava;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ApplicationRunner {

    public static void main(String[] args) throws JsonProcessingException {
        ApplicationRunner app = new ApplicationRunner();
        String responseBody = app.get();
        ObjectMapper mapper = new ObjectMapper();
        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

        ImdbResponse parsedValue = mapper.readValue(responseBody, ImdbResponse.class);
        System.out.println(parsedValue);
    }

    public String get() {

        try {
            HttpRequest request = HttpRequest
                    .newBuilder()
                    .uri(new URI("https://imdb-api.com/en/API/Top250Movies/k_dhx0o8xd"))
                    .GET()
                    .build();
            HttpClient client = HttpClient.newHttpClient();
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            return response.body();

        } catch (URISyntaxException e) {
            System.out.println("erro ao construir a url");
            throw new RuntimeException("erro ao construir a url");
        } catch (IOException | InterruptedException e) {
            System.out.println("erro ao executar o request");
            throw new RuntimeException("erro ao executar o request");
        }

    }
}

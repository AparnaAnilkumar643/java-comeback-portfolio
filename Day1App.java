import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.Duration;

public class Day1App {

    // Define a Java record to safely model the expected JSON response (Joke API)
    public record JokeResponse(String id, String joke, int status) {}

    public static void main(String[] args) {
        System.out.println("Fetching a fresh developer joke for Day 1...");

        String url = "https://icanhazdadjoke.com/";

        // Initialize the modern Java HttpClient
        try (HttpClient client = HttpClient.newBuilder()
                .connectTimeout(Duration.ofSeconds(10))
                .build()) {

            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(url))
                    .header("Accept", "application/json")
                    .header("User-Agent", "Java-Comeback-Portfolio-App")
                    .GET()
                    .build();

            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

            if (response.statusCode() == 200) {
                // Manual or basic parsing into our record (keeping it dependency-free for Day 1)
                String body = response.body();
                System.out.println("\nAPI Response Received Successfully!");
                System.out.println(body);
            } else {
                System.err.println("Failed to fetch data. Status code: " + response.statusCode());
            }

        } catch (Exception e) {
            System.err.println("An error occurred during network execution: " + e.getMessage());
        }
    }
}
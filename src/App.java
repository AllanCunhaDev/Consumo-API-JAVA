import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse.BodyHandlers;

public class App {
    public static void main(String[] args) throws Exception {
        String url = "https://api.themoviedb.org/3/movie/550?api_key=abd88ad13d8fd5a5249134cc8f87e8d4";
        URI end = URI.create(url);
        var client = HttpClient.newHttpClient();
        var request = HttpRequest.newBuilder(end).GET().build();
        var response = client.send(request, BodyHandlers.ofString());
        String body = response.body();
        System.out.println(body);

    }
}

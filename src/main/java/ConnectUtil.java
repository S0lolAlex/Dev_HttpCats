import java.io.IOException;
import java.net.URI;
import java.net.http.*;

public class ConnectUtil {
    public int getConnect(int code){
        String uri = "https://http.cat/" + code + ".jpg";
        HttpRequest.BodyPublisher bodyPublisher = HttpRequest.BodyPublishers.noBody();
        HttpResponse<String> response = null;
        response = getResponse(uri);
        return response.statusCode();
    }
    private HttpResponse<String> getResponse(String url)
            {
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest
                .newBuilder()
                .uri(URI.create(url))
                .GET()
                .build();
                try {
                    return client.send(request, HttpResponse.BodyHandlers.ofString());
                } catch (IOException | InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
}

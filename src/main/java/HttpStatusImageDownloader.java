import java.io.InputStream;
import java.net.URL;
import java.nio.file.*;

public class HttpStatusImageDownloader {
    public void downloadStatusImage(int code) throws Exception {
            String statusImage = new HttpStatusChecker().getStatusImage(code);
            try(InputStream in = new URL(statusImage).openStream()){
               Path path = Paths.get("./src/main/resources/image.jpg");
                boolean exists = Files.exists(path);
                if(exists){
                    Files.delete(path);
                }
                Files.copy(in, Paths.get(path.toUri()));
            }
    }
}

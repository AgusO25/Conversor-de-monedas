package src.main.java.AgusO25;



import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import com.google.gson.Gson;


public class Consultar{

  public Conversor obtenerTasa(String monedaBase, String monedaDestino) {
        
        URI url = URI.create("https://v6.exchangerate-api.com/v6/b67a00bbb3f485c4e441570d/pair/" + monedaBase + "/" + monedaDestino);

        
        HttpClient cliente = HttpClient.newHttpClient();

        
        HttpRequest solicitud = HttpRequest.newBuilder().uri(url).build();

        try {
            
            HttpResponse<String> respuesta = cliente.send(solicitud, HttpResponse.BodyHandlers.ofString());

            
            return new Gson().fromJson(respuesta.body(), Conversor.class);

        } catch (IOException | InterruptedException e) {
            System.out.println("Ocurrió un error al consultar la API: " + e.getMessage());
            return null;
        }
    }
}
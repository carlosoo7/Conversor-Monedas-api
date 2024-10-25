package app;

import com.google.gson.Gson;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class EjecucionDeConversion {
    public Double EjecucionConversion(String Monedaconsulta, String Conversion, Double valor) {
        URI direccion = URI.create("https://v6.exchangerate-api.com/v6/9d83d728f4273541a9468e87/latest/" + Monedaconsulta);
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder().uri(direccion).build();

        try {
            HttpResponse<String> response = client
                    .send(request, HttpResponse.BodyHandlers.ofString());
            Moneda moneda = new Gson().fromJson(response.body(), Moneda.class);
            Double valorconvercion=moneda.conversion_rates().get(Conversion);
            return valorconvercion * valor;
        } catch (InterruptedException | IOException e) {
            throw new RuntimeException("No se encontro la  Moneda");
        }


    }
}

package app;

import com.google.gson.Gson;

import javax.swing.*;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class EjecucionDeConversion {
    public Double EjecucionConversion(String Monedaconsulta, String Conversion, Double valor) {
        URI direccion = URI.create("https://v6.exchangerate-api.com/v6/9d83d728f4273541a9468e87/latest/" + Monedaconsulta);
        HttpClient client = HttpClient.newHttpClient(); //client y request encargados de ejecutar la consulta
        HttpRequest request = HttpRequest.newBuilder().uri(direccion).build();

        try {
            HttpResponse<String> response = client
                    .send(request, HttpResponse.BodyHandlers.ofString());
            Moneda moneda = new Gson().fromJson(response.body(), Moneda.class); //Objeto del tipo moneda que guardara el json con las conversiones
            Double valorconvercion=moneda.conversion_rates().get(Conversion); //llamado del valor a coinvertir solicitado
            return valorconvercion * valor; //return del valor solicitado por la cantidad que se desea convertir
        } catch (InterruptedException | IOException e) {
            JOptionPane.showMessageDialog(null,"Error en la ejecucion de conversion, intente mas tarde"); //en caso de error de consulta  salta mensaje
            throw new RuntimeException("Error en la ejecucion de conversion");
        }


    }
}

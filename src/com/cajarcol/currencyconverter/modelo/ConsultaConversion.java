package com.cajarcol.currencyconverter.modelo;

import com.google.gson.Gson;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ConsultaConversion {
    public ConversionMoneda conviertaMoneda(String monedaOrigen, String monedaDestino, double cantidad){
        URI direccion = URI.create("https://v6.exchangerate-api.com/v6/4d9dbdad0527017696ed25c4/pair/" + monedaOrigen + "/" + monedaDestino + "/" + cantidad);

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(direccion)
                .build();

        try {
            HttpResponse<String> response = client
                    .send(request, HttpResponse.BodyHandlers.ofString());
            return new Gson().fromJson(response.body(), ConversionMoneda.class);
        } catch (Exception e) {
            throw new RuntimeException("Ocurrio un error inesperado.");
        }
    }
}

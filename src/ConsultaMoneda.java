import com.google.gson.Gson;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Map;
import java.util.Scanner;

public class ConsultaMoneda {
   private static final String API_KEY = "aaea6c7f2606d4cf4a4eb3e9";

    public Moneda buscarMoneda(String monedaBase, String monedaTarget) {
        // Construcción de la URL para obtener las tasas de cambio
        URI direccion = URI.create("https://v6.exchangerate-api.com/v6/" + API_KEY + "/latest/" + monedaBase);
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(direccion)
                .build();
        try {
            /// Realizo la solicitud
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            // Parseo la respuesta de la API
            Gson gson = new Gson();
            Moneda monedas = gson.fromJson(response.body(), Moneda.class);

            return monedas;
        } catch (IOException | InterruptedException e) {
            throw new RuntimeException("No se ha encontrado dicha tasa de conversión para estas monedas");
        }
    }
    public static void convertirMoneda(String monedaBase, String monedaTarget, ConsultaMoneda consulta, Scanner teclado) {
        double cantidad;
        double cantidadConvertida;

        // Se consulta la tasa de conversión para la moneda base y la moneda objetivo
        Moneda monedas = consulta.buscarMoneda(monedaBase, monedaTarget);

        // Se obtiene la tasa de conversión de la moneda objetivo
        Map<String, Double> tasasConversion = monedas.conversion_rates();
        Double tasa = tasasConversion.get(monedaTarget); // Aquí obtenemos la tasa para la moneda objetivo

        if (tasa == null) {
            System.out.println("No se encontró la tasa de conversión para " + monedaTarget);
            return;
        }

        // Se muestra la tasa de conversión
        System.out.println("La tasa de conversión es: " + monedaBase + " = " + tasa + " " + monedaTarget);
        System.out.println("Ingrese la cantidad de : " + monedaBase);
        cantidad = Double.parseDouble(teclado.nextLine());

        // Se calcula la cantidad convertida
        cantidadConvertida = cantidad * tasa;
        System.out.printf("%s %s = %s %s%n", cantidad, monedaBase, cantidadConvertida, monedaTarget);
    }
}












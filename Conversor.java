import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Map;

public class Conversor {

    private static final String API_KEY = "eef1859778bd5c2149ed6cf6"; // <-- Reemplaza con tu clave
    private static final String API_URL = "https://v6.exchangerate-api.com/v6/" + API_KEY + "/latest/";

    public static double convertir(String monedaBase, String monedaDestino, double cantidad) {
        try {
            URL url = new URL(API_URL + monedaBase);
            HttpURLConnection conexion = (HttpURLConnection) url.openConnection();
            conexion.setRequestMethod("GET");

            BufferedReader in = new BufferedReader(new InputStreamReader(conexion.getInputStream()));
            StringBuilder respuestaJson = new StringBuilder();
            String linea;
            while ((linea = in.readLine()) != null) {
                respuestaJson.append(linea);
            }
            in.close();

            Gson gson = new Gson();
            RespuestaAPI respuesta = gson.fromJson(respuestaJson.toString(), RespuestaAPI.class);

            Double tasa = respuesta.conversion_rates.get(monedaDestino.toUpperCase());
            if (tasa == null) {
                System.out.println("Moneda no válida: " + monedaDestino);
                return -1;
            }

            return cantidad * tasa;

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
            return -1;
        }
    }

    // Clase interna para mapear la respuesta JSON
    static class RespuestaAPI {
        Map<String, Double> conversion_rates;
    }
}

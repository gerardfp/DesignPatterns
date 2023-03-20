package callback.hipoteca;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

class SimuladorHipoteca {
    static double calcularCuota(double capital, double plazo) {
        double interes = 0;

        try {
            interes = Double.parseDouble(HttpClient.newHttpClient().send(HttpRequest.newBuilder()
                    .uri(URI.create("https://fakebank-tan.vercel.app/api/get-interest"))
                    .GET().build(), HttpResponse.BodyHandlers.ofString()).body());
        } catch (Exception e) {
            // error obteniendo interes
        }

        return capital*interes/12/(1-Math.pow(1+(interes/12),-plazo*12));
    }
}

public class Main {
    public static void main(String[] args) {
        double cuota = SimuladorHipoteca.calcularCuota(2000, 2);

        System.out.println(cuota);
    }
}

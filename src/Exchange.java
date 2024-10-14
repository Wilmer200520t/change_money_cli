import com.google.gson.Gson;
import com.google.gson.JsonObject;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.io.IOException;

public class Exchange {
    private static final String API_URL = "https://v6.exchangerate-api.com/v6/a2c8e9ddacb8968f48738de5/latest/USD";
    private Gson gson;
    private HttpClient client;

    public Exchange() {
        this.gson = new Gson();
        this.client = HttpClient.newHttpClient();
    }

    public double getExchange(String fromCurrency, String toCurrency, double amount) throws IOException, InterruptedException {
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(API_URL))
                .header("Accept", "application/json")
                .header("User-Agent", "Java HttpClient")
                .build();

        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

        // Parseo a JSON
        String responseBody = response.body();
        JsonObject jsonObject = gson.fromJson(responseBody, JsonObject.class);
        JsonObject conversionRates = jsonObject.getAsJsonObject("conversion_rates");

        // Verificar si las monedas están en la respuesta
        if (!conversionRates.has(fromCurrency) || !conversionRates.has(toCurrency)) {
            throw new IllegalArgumentException("Currency code not found in the rates.");
        }

        // Obtener las tasas de cambio
        double fromRate = conversionRates.get(fromCurrency).getAsDouble();
        double toRate = conversionRates.get(toCurrency).getAsDouble();

        return (amount / fromRate) * toRate;
    }

}

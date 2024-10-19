package com.ConvertirMoneda;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class ServiciodeCambio {
    final String apiKey = "835e2c3ec476ba10d747fd40"; // clave API personal
    final String baseUrl = "https://v6.exchangerate-api.com/v6/";

    public double getExchangeRate(String fromCurrency, String toCurrency) throws Exception {
        String urlStr = baseUrl + apiKey + "/latest/" + fromCurrency;
        URL url = new URL(urlStr);
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("GET");

        BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
        StringBuilder response = new StringBuilder();
        String inputLine;

        while ((inputLine = in.readLine()) != null) {
            response.append(inputLine);
        }
        in.close();

        JsonObject jsonObject = JsonParser.parseString(response.toString()).getAsJsonObject();
        return jsonObject.getAsJsonObject("conversion_rates").get(toCurrency).getAsDouble();
    }
}

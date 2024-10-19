package com.ConvertirMoneda;

public class ConvertirMoneda {
    private double tasa;

    public ConvertirMoneda(double tasa) {
        this.tasa = tasa;
    }

    public double convertir(double cantidad) {
        return cantidad * tasa;
    }
}

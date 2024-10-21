package com.ConvertirMoneda;

import java.util.Scanner;

public class Interfaz {
    private Scanner scanner;
    private ServiciodeCambio serviciodeCambio;

    public Interfaz() {
        scanner = new Scanner(System.in);
        serviciodeCambio = new ServiciodeCambio();
    }

    public void iniciar() {
        while (true) {
            mostrarMenu();
            int opcion = scanner.nextInt();

            if (opcion == 7) {
                break;
            }

            double cantidad = 0;
            if (opcion < 7) {
                System.out.print("Ingrese la cantidad: ");
                cantidad = scanner.nextDouble();
            }

            procesarOpcion(opcion, cantidad);
        }

        scanner.close();
    }

    private void mostrarMenu() {
        System.out.println("************************************");
        System.out.println("*         Menú de Opciones          *");
        System.out.println("************************************");
        System.out.println("*   1. Dólar ==> Peso Argentino     *");
        System.out.println("*   2. Peso Argentino ==> Dólar     *");
        System.out.println("*   3. Dólar ==> Real Brasileño     *");
        System.out.println("*   4. Real Brasileño ==> Dólar     *");
        System.out.println("*   5. Dólar ==> Peso Colombiano    *");
        System.out.println("*   6. Peso Colombiano ==> Dólar    *");
        System.out.println("*   7. Salir                        *");
        System.out.println("************************************");
        System.out.print("******  Seleccione una opción: ");
    }

    private void procesarOpcion(int opcion, double cantidad) {
        try {
            double tasa = obtenerTasa(opcion);
            String monedaCanbio = obtenerMonedaCanbio(opcion);
            String moneda = obtenerMoneda(opcion);

            ConvertirMoneda converter = new ConvertirMoneda(tasa);
            double convertedAmount = converter.convertir(cantidad);
            System.out.printf("Cantidad de: %.2f %s corresponde al valor final de %.2f %s%n", cantidad, monedaCanbio, convertedAmount, moneda);
        } catch (Exception e) {
            System.out.println("Error al obtener la tasa de cambio: " + e.getMessage());
        }
    }

    private double obtenerTasa(int opcion) throws Exception {
        switch (opcion) {
            case 1: return serviciodeCambio.getExchangeRate("USD", "ARS");
            case 2: return serviciodeCambio.getExchangeRate("ARS", "USD");
            case 3: return serviciodeCambio.getExchangeRate("USD", "BRL");
            case 4: return serviciodeCambio.getExchangeRate("BRL", "USD");
            case 5: return serviciodeCambio.getExchangeRate("USD", "COP");
            case 6: return serviciodeCambio.getExchangeRate("COP", "USD");
            default: throw new Exception("Opción no válida.");
        }
    }

    private String obtenerMonedaCanbio(int opcion) {
        switch (opcion) {
            case 1: return "dólares";
            case 2: return "pesos argentinos";
            case 3: return "dólares";
            case 4: return "reales brasileños";
            case 5: return "dólares";
            case 6: return "pesos colombianos";
            default: return "";
        }
    }

    private String obtenerMoneda(int opcion) {
        switch (opcion) {
            case 1: return "Pesos argentinos";
            case 2: return "dólares";
            case 3: return "Reales brasileños";
            case 4: return "dólares";
            case 5: return "Pesos colombianos";
            case 6: return "dólares";
            default: return "";
        }
    }
}

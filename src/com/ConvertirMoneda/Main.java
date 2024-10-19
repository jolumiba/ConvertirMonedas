package com.ConvertirMoneda;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ServiciodeCambio solicitarCambio = new ServiciodeCambio();

        while (true) {
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

            System.out.println("******  Seleccione una opción: ");

            int opcion = scanner.nextInt();

            if (opcion == 7) {
                break;
            }

            double tasa;
            String monedaCanbio, moneda;
            double cantidad = 0;
            if (opcion < 7) {
                System.out.print("Ingrese la cantidad: ");
                cantidad = scanner.nextDouble();

            }

            try {
                switch (opcion) {
                    case 1:
                        tasa = solicitarCambio.getExchangeRate("USD", "ARS");
                        monedaCanbio="dólares";
                        moneda = "Pesos argentinos";
                        break;
                    case 2:
                        tasa = solicitarCambio.getExchangeRate("ARS", "USD");
                        monedaCanbio="pesos argentinos";
                        moneda = "dólares";
                        break;
                    case 3:
                        tasa = solicitarCambio.getExchangeRate("USD", "BRL");
                        monedaCanbio="dólares";
                        moneda = "Reales brasileños";
                        break;
                    case 4:
                        tasa = solicitarCambio.getExchangeRate("BRL", "USD");
                        monedaCanbio="reales brasileños";
                        moneda = "dólares";
                        break;
                    case 5:
                        tasa = solicitarCambio.getExchangeRate("USD", "COP");
                        monedaCanbio="dólares";
                        moneda = "Pesos colombianos";
                        break;
                    case 6:
                        tasa = solicitarCambio.getExchangeRate("COP", "USD");
                        monedaCanbio="pesos colombianos";
                        moneda = "dólares";
                        break;
                    default:
                        System.out.println("Opción no válida. Vuelva a intemtarlo");
                        continue;
                }

                ConvertirMoneda converter = new ConvertirMoneda(tasa);
                double convertedAmount = converter.convertir(cantidad);
                System.out.printf("Cantidad de: %.2f %s corresponde al valor final de %.2f %s%n", cantidad, monedaCanbio, convertedAmount, moneda);
            } catch (Exception e) {
                System.out.println("Error al obtener la tasa de cambio: " + e.getMessage());
            }
        }

        scanner.close();
    }
}

package com.cajarcol.currencyconverter.principal;

import com.cajarcol.currencyconverter.modelo.ConsultaConversion;
import com.cajarcol.currencyconverter.modelo.ConversionMoneda;

import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {

        Scanner lectura = new Scanner(System.in);
        int opcion = 0;

        String menu = """
*******************************************************
Sea bienvenido/a al Conversor de Moneda =]

1) Dólar =>> Peso argentino
2) Peso argentino =>> Dólar
3) Dólar =>> Real brasileño
4) Real brasileño =>> Dólar
5) Dólar =>>> Peso colombiano
6) Peso colombiano =>> Dólar
7) Salir
Elija una opción válida:
*******************************************************

                """;

        while (opcion != 7){

            System.out.println(menu);

            opcion = lectura.nextInt();

            if (opcion >= 1 && opcion <= 6) {

                ConsultaConversion consulta = new ConsultaConversion();
                System.out.println("Ingrese el valor que deseas convertir:");
                double cantidad = lectura.nextInt();
                String monedaOrigen = "";
                String monedaDestino = "";

                switch (opcion){
                    case 1:
                        monedaOrigen = "USD";
                        monedaDestino = "ARS";
                        break;
                    case 2:
                        monedaOrigen = "ARS";
                        monedaDestino = "USD";
                        break;
                    case 3:
                        monedaOrigen = "USD";
                        monedaDestino = "BRL";
                        break;
                    case 4:
                        monedaOrigen = "BRL";
                        monedaDestino = "USD";
                        break;
                    case 5:
                        monedaOrigen = "USD";
                        monedaDestino = "COP";
                        break;
                    case 6:
                        monedaOrigen = "COP";
                        monedaDestino = "USD";
                        break;
                    default:
                        break;
                }

                ConversionMoneda conversion = consulta.conviertaMoneda(monedaOrigen, monedaDestino, cantidad);

                System.out.println("El valor " + cantidad + " [" + monedaOrigen + "] corresponde al valor final de =>>> " + conversion.conversion_result() + " [" + monedaDestino + "]");
            } else if (opcion == 7) {
                System.out.println("Finalizando el programa. Muchas gracias por usar nuestros servicios");
                break;
            } else {
                System.out.println("Opción inválida");
            }
        }
    }
}

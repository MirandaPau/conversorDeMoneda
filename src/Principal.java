

import com.google.gson.Gson;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {

        Scanner teclado = new Scanner(System.in);
        ConsultaMoneda consulta = new ConsultaMoneda();  // Se crea una instancia de ConsultaMoneda
        int opcion = 0;

        while (opcion != 7) {
            System.out.println("""
                *********************************************
                Sea bienvenido/a al Conversor de Moneda =]

                1) Dólar => Peso argentino
                2) Peso argentino => Dólar
                3) Dólar => Real brasileño
                4) Real brasileño => Dólar
                5) Dólar => Peso colombiano
                6) Peso colombiano => Dólar
                7) Salir
                Elija una opción válida:
                *********************************************
                """);

            opcion = teclado.nextInt();
            teclado.nextLine();

            switch (opcion) {
                case 1:
                    ConsultaMoneda.convertirMoneda("USD", "ARS", consulta, teclado);
                    break;
                case 2:
                    ConsultaMoneda.convertirMoneda("ARS", "USD", consulta, teclado);
                    break;
                case 3:
                    ConsultaMoneda.convertirMoneda("USD", "BRL", consulta, teclado);
                    break;
                case 4:
                    ConsultaMoneda.convertirMoneda("BRL", "USD", consulta, teclado);
                    break;
                case 5:
                    ConsultaMoneda.convertirMoneda("USD", "COP", consulta, teclado);
                    break;
                case 6:
                    ConsultaMoneda.convertirMoneda("COP", "USD", consulta, teclado);
                    break;
                case 7:
                    System.out.println("Saliendo del conversor...");
                    break;
                default:
                    System.out.println("Opción inválida. Intente nuevamente.");
                    break;
            }
        }
    }


    }




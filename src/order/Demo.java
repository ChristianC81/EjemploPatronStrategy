/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package order;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import strategies.EstrategiaDePago;
import strategies.PagoPorPayPal;
import strategies.PagoPorTarjetaDeCredito;

/**
 *
 * @author chris
 */
public class Demo {
     private static Map<Integer, Integer> precioEnProductos = new HashMap<>();
    private static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    private static Orden order = new Orden();
    private static EstrategiaDePago strategy;

    static {
        precioEnProductos.put(1, 180);
        precioEnProductos.put(2, 200);
        precioEnProductos.put(3, 65);
        precioEnProductos.put(4, 25);
    }

    public static void main(String[] args) throws IOException {
        while (!order.isCerrado()) {
            int cost;

            String continueChoice;
            do {
                System.out.println("TIENDA ELECTRONICA S.A");
                System.out.println("---------|Menu|---------");
                System.out.print("Por Favor, seleccione un producto" + "\n" +
                        "1 - Placa Madre" + "\n" +
                        "2 - CPU" + "\n" +
                        "3 - HDD" + "\n" +
                        "4 - Memoria RAM" + "\n");
                int choice = Integer.parseInt(reader.readLine());
                cost = precioEnProductos.get(choice);
                System.out.print("Cantidad: ");
                int count = Integer.parseInt(reader.readLine());
                order.setTotalCosto(cost * count);
                System.out.print("¿Desea continuar seleccionando productos? Y/N: ");
                continueChoice = reader.readLine();
            } while (continueChoice.equalsIgnoreCase("Y"));

            if (strategy == null) {
                System.out.println("Por favor seleccione un método de pago:" + "\n" +
                        "1 - PalPay" + "\n" +
                        "2 - Tarjeta de Credito");
                String paymentMethod = reader.readLine();

                // El cliente crea diferentes estrategias basadas en la entrada del usuario,
                 // configuración de la aplicación, etc.
                if (paymentMethod.equals("1")) {
                    strategy = new PagoPorPayPal();
                } else {
                    strategy = new PagoPorTarjetaDeCredito();
                }
            }

           // Los delegados del objeto de pedido recopilan datos de pago para el objeto de estrategia,
             // ya que solo las estrategias saben qué datos necesitan para procesar un
             // pago.
            order.procesarOrden(strategy);

            System.out.print("Precio Total " + order.getTotalCosto()+ " dolares, Desea continuar comprando? P/C: ");
            String proceed = reader.readLine();
            if (proceed.equalsIgnoreCase("P")) {
                // Finalmente, la estrategia maneja el pago.
                if (strategy.pago(order.getTotalCosto())) {
                    System.out.println("El pago ha sido exitoso.");
                     System.out.println("Gracias por Preferirnos");
                } else {
                    System.out.println("¡FALLO! Por favor, revisa tus datos.");
                }
              order.setCerrado();
            }else{
                  System.out.println("Vuelva pronto!");
                  System.out.println("");
            }
        }
    }
}

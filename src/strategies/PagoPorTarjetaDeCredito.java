/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package strategies;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
/**
 *
 * @author chris
 */
public class PagoPorTarjetaDeCredito implements EstrategiaDePago{
    private final BufferedReader READER = new BufferedReader(new InputStreamReader(System.in));
    private TarjetaDeCredito card;

    /**
     * Collect credit card data.
     */
    @Override
    public void recogerPagoDetalles() {
        try {
            System.out.print("Ingrese el numero de tarjeta: ");
            String number = READER.readLine();
            System.out.print("Ingrese la fecha de expiracion 'mm/yy': ");
            String date = READER.readLine();
            System.out.print("Ingrese el codigo CVV: ");
            String cvv = READER.readLine();
            card = new TarjetaDeCredito(number, date, cvv);

            // Validate credit card number...

        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    /**
     * After card validation we can charge customer's credit card.
     */
    @Override
    public boolean pago(int monto) {
        if (cardIsPresent()) {
            System.out.println("Pagando " + monto + " usando Tarjeta de Credito.");
            card.setMonto(card.getMonto()- monto);
            return true;
        } else {
            return false;
        }
    }

    private boolean cardIsPresent() {
        return card != null;
    }
}

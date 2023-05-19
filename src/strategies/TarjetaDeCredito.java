/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package strategies;

/**
 *
 * @author chris
 */
public class TarjetaDeCredito {
    private int monto;
    private String numero;
    private String fecha;
    private String cvv;

    public TarjetaDeCredito(String numero, String fecha, String cvv) {
        this.monto = 100_000;
        this.numero = numero;
        this.fecha = fecha;
        this.cvv = cvv;
    }

    public int getMonto() {
        return monto;
    }

    public void setMonto(int monto) {
        this.monto = monto;
    }
    
}

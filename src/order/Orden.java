/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package order;

import strategies.EstrategiaDePago;

/**
 *
 * @author chris
 */

public class Orden {
    private int totalCosto = 0;
    private boolean cerrado = false;

    public void procesarOrden(EstrategiaDePago estrategia) {
        estrategia.recogerPagoDetalles();
    }

    public int getTotalCosto() {
        return totalCosto;
    }

    public void setTotalCosto(int totalCosto) {
        this.totalCosto = totalCosto;
    }

    public boolean isCerrado() {
        return cerrado;
    }

    public void setCerrado() {
        this.cerrado = true;
    }

}

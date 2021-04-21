/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Examen_Final_Fila_B;

import java.io.Serializable;

/**
 *
 * @author SmartUrban2025
 */
public class Producto implements Serializable{
    static final long serialVersionUID=55L;
    private String nomprod;
    private float costounit;
    private int stock;

    public String getNomprod() {
        return nomprod;
    }

    public void setNomprod(String nomprod) {
        this.nomprod = nomprod;
    }

    public float getCostounit() {
        return costounit;
    }

    public void setCostounit(float costounit) {
        this.costounit = costounit;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }
}
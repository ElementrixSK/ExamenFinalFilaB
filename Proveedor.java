/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Examen_Final_Fila_B;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author SmartUrban2025
 */
public class Proveedor implements Serializable{
    static final long serialVersionUID=55L;
    private String rsocial;
    private String direccion;
    private int nrotelefono;
    private List<Producto> ListaProd;
    
     public Proveedor() {
        ListaProd = new ArrayList<>();
    }
    
    public String getRsocial() {
        return rsocial;
    }

    public void setRsocial(String rsocial) {
        this.rsocial = rsocial;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public int getNrotelefono() {
        return nrotelefono;
    }

    public void setNrotelefono(int nrotelefono) {
        this.nrotelefono = nrotelefono;
    }

    public List<Producto> getListaProd() {
        return ListaProd;
    }

    public void setListaProd(List<Producto> ListaProd) {
        this.ListaProd = ListaProd;
    }
}
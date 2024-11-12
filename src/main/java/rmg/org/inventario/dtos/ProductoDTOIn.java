/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package rmg.org.inventario.dtos;

import rmg.org.inventario.entities.Producto;

/**
 *
 * @author loken
 */

public class ProductoDTOIn {
    private long cantidad;
    private String producto;
    private long unidadMedida;
    private int stockMinimo;

    public long getCantidad() {
        return cantidad;
    }

    public void setCantidad(long cantidad) {
        this.cantidad = cantidad;
    }

    public String getProducto() {
        return producto;
    }

    public void setProducto(String producto) {
        this.producto = producto;
    }

    public long getUnidadMedida() {
        return unidadMedida;
    }

    public void setUnidadMedida(long unidadMedida) {
        this.unidadMedida = unidadMedida;
    }

    
}

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
public class ProductoDTOOut{
    private long prodructoId;
    private long cantidad;
    private String producto;
    private String unidadMedida;
    private int stockMinimo;

    public ProductoDTOOut() {
    }

    public ProductoDTOOut(Producto producto) {
        this.prodructoId  = producto.getProductoId();
        this.cantidad     = producto.getCantidad();
        this.producto     = producto.getProducto();
        this.unidadMedida = producto.getUnidadMedida().getUnidadMedida();
        this.stockMinimo = producto.getStockMinimo();
    }
    
    public long getProdructoId() {
        return prodructoId;
    }

    public void setProdructoId(long prodructoId) {
        this.prodructoId = prodructoId;
    }

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

    public String getUnidadMedida() {
        return unidadMedida;
    }

    public void setUnidadMedida(String unidadMedida) {
        this.unidadMedida = unidadMedida;
    }

    public int getStockMinimo() {
        return stockMinimo;
    }

    public void setStockMinimo(int stockMinimo) {
        this.stockMinimo = stockMinimo;
    }

    
    
}

package rmg.org.inventario.entities;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author loken
 */
@Entity
@Table (name = "productos")
public class Producto {
    @Id
    @Column(name = "productoid")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long productoId;
    
    @Column(name = "cantidad")
    private long cantidad;
    
    @Column(name = "producto")
    private String producto;
    
    @Column(name = "stock_minimo")
    private int stockMinimo;

    public int getStockMinimo() {
        return stockMinimo;
    }

    public void setStockMinimo(int stockMinimo) {
        this.stockMinimo = stockMinimo;
    }
    @ManyToOne
    @JoinColumn(name = "unidadmedida")
    private UnidadMedida unidadMedida;

    public Producto() {
    }

    public Producto(long cantidad, String producto, UnidadMedida unidadMedida) {
        this.cantidad = cantidad;
        this.producto = producto;
        this.unidadMedida = unidadMedida;
    }

    public long getProductoId() {
        return productoId;
    }

    public void setProductoId(long productoId) {
        this.productoId = productoId;
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

    public UnidadMedida getUnidadMedida() {
        return unidadMedida;
    }

    public void setUnidadMedida(UnidadMedida unidadMedida) {
        this.unidadMedida = unidadMedida;
    }
    
    
}

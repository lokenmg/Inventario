package rmg.org.inventario.entities;

import rmg.org.inventario.entities.Producto;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Column;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import org.springframework.beans.factory.annotation.Value;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author loken
 */
@Entity
@Table(name = "unidadmedida")
public class UnidadMedida {

    @Id
    @Column(name = "unidadmedidaid")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long unidadMedidaId;
    
    @Column(name = "unidadmedida")
    private String unidadmedida;

    @OneToMany(mappedBy = "unidadMedida", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Producto> productos = new ArrayList<>();

    public long getUnidadMedidaId() {
        return unidadMedidaId;
    }

    public void setUnidadMedidaId(long unidadMedidaId) {
        this.unidadMedidaId = unidadMedidaId;
    }

    public String getUnidadMedida() {
        return unidadmedida;
    }

    public void setUnidadMedida(String unidadMedida) {
        this.unidadmedida = unidadMedida;
    }

    public List<Producto> getProductos() {
        return productos;
    }

    public void setProductos(List<Producto> productos) {
        this.productos = productos;
    }

}

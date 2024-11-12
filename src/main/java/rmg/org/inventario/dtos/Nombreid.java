/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package rmg.org.inventario.dtos;

/**
 *
 * @author loken
 */
public class Nombreid extends Nombre{
    private long id;

    public Nombreid(String nombre, long id) {
        super(nombre);
        this.id = id;
    }

    public Nombreid() {
    }

    
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
    
    
    
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package rmg.org.inventario.dtos;

import javax.validation.constraints.NotBlank;

/**
 *
 * @author loken
 */
public class Nombre {
    
    @NotBlank
    private String nombre;

    public Nombre(String nombre){
        this.nombre = nombre;
    }
    
    public Nombre(){
        
    }
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
}

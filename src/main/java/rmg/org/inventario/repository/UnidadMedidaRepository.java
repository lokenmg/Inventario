/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/springframework/Repository.java to edit this template
 */
package rmg.org.inventario.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import rmg.org.inventario.entities.UnidadMedida;
/**
 *
 * @author loken
 */
public interface UnidadMedidaRepository extends JpaRepository<UnidadMedida, Long> {
    
}

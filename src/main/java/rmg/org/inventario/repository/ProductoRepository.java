/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package rmg.org.inventario.repository;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import rmg.org.inventario.entities.Producto;
import java.util.List;
/**
 *
 * @author loken
 */
@Repository
public interface ProductoRepository extends JpaRepository<Producto, Long> {
    
    List<Producto> findAll(Sort sort);
}

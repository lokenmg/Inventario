/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/springframework/Controller.java to edit this template
 */
package rmg.org.inventario.controller;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import rmg.org.inventario.dtos.Nombre;
import rmg.org.inventario.dtos.Nombreid;
import rmg.org.inventario.entities.UnidadMedida;
import rmg.org.inventario.services.UnidadMedidaService;

/**
 *
 * @author loken
 */
@RestController
@RequestMapping("/medida")
public class MedidaController {
    
    private final UnidadMedidaService medidaService;
    
    public MedidaController(UnidadMedidaService medidaService){
        this.medidaService = medidaService;
    }
    
    
    @PostMapping()
    public ResponseEntity<Nombre> save(@RequestBody Nombre categoria){
        Optional<UnidadMedida> nuevaMedidad = medidaService.crearUnidadMedida(categoria);
        if(nuevaMedidad.isPresent()){
            Nombre medidaAgregada = new Nombre(nuevaMedidad.get().getUnidadMedida());
            URI ubication = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(nuevaMedidad.get().getUnidadMedidaId()).toUri();
            
            return ResponseEntity.created(ubication).body(categoria);
        }else{
            return ResponseEntity.noContent().build();
        }
    }
    
    
    @GetMapping()
    public ResponseEntity<List<Nombreid>> getAll(){
        List<UnidadMedida>medidas = medidaService.getAllUnidadMedidas().get();
        List<Nombreid> nombres = new ArrayList<>();
        if(medidas.isEmpty()){
            return ResponseEntity.notFound().build();
        }else{
            for (UnidadMedida unidadMedida : medidas) {
                nombres.add(new Nombreid(unidadMedida.getUnidadMedida(), unidadMedida.getUnidadMedidaId()));
            }
            
            return ResponseEntity.ok(nombres);
        }
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<Nombre> getById(@PathVariable long id){
        Optional<UnidadMedida> medida = medidaService.getUnidadMedidaById(id);
        
        if(medida.isPresent()){
            return ResponseEntity.ok(new Nombre(medida.get().getUnidadMedida()));
        }else{
            return ResponseEntity.notFound().build();
        }
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<Nombre> putById(@PathVariable long id, @RequestBody Nombre nombre){
        Optional<UnidadMedida> actual = medidaService.updateUnidadMedida(id, nombre);
        if(actual.isPresent()){
            return ResponseEntity.ok(new Nombre(actual.get().getUnidadMedida()));
        }else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> deleteById (@PathVariable long id){
        boolean eliminado = medidaService.deleteUnidadMedida(id);
        
        if (eliminado){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    } 
}

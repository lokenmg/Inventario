/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package rmg.org.inventario.services;

import javax.transaction.Transactional;
import org.springframework.stereotype.Service;
import rmg.org.inventario.dtos.Nombre;
import rmg.org.inventario.entities.UnidadMedida;
import rmg.org.inventario.repository.UnidadMedidaRepository;
import java.util.List;
import java.util.ArrayList;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
/**
 *
 * @author loken
 */
@Service
public class UnidadMedidaService {
    
    private final UnidadMedidaRepository medidaRepository;
    
    @Autowired
    public UnidadMedidaService(UnidadMedidaRepository medidaRepository){
        this.medidaRepository= medidaRepository;
    }
    
    @Transactional
    public Optional<UnidadMedida> crearUnidadMedida (Nombre nombre){
        UnidadMedida nuevaUnidadMedia= new UnidadMedida();
        nuevaUnidadMedia.setUnidadMedida(nombre.getNombre()); 
        return Optional.of(medidaRepository.save(nuevaUnidadMedia));
    }
    
    public Optional<List<UnidadMedida>> getAllUnidadMedidas(){
        List<UnidadMedida> medidas = new ArrayList<>();
         medidas = medidaRepository.findAll();
         return Optional.of(medidas);
    }
    
    public Optional<UnidadMedida> getUnidadMedidaById(long id){
        return medidaRepository.findById(id);
    }
    
    @Transactional
    public boolean deleteUnidadMedida(long id){
        Optional<UnidadMedida> eliinar = medidaRepository.findById(id);
        if (eliinar.isPresent()){
            medidaRepository.deleteById(id);
            return true;
        }else{
            return false;
        }
        
    }
    
    
    @Transactional
    public Optional<UnidadMedida> updateUnidadMedida(long id, Nombre cambio){
        Optional<UnidadMedida> unidadEncontrada = medidaRepository.findById(id);
        
        if (unidadEncontrada.isPresent()){
            UnidadMedida unidadMedida = unidadEncontrada.get();
            unidadMedida.setUnidadMedida(cambio.getNombre());
            return Optional.of(medidaRepository.save(unidadMedida));
        }else{
            return Optional.empty();
        }
    }
    }
    
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/springframework/Service.java to edit this template
 */
package rmg.org.inventario.services;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import rmg.org.inventario.dtos.ProductoDTOIn;
import rmg.org.inventario.entities.UnidadMedida;
import rmg.org.inventario.repository.ProductoRepository;
import java.util.Optional;
import org.springframework.transaction.annotation.Transactional;
import rmg.org.inventario.dtos.ProductoDTOOut;
import rmg.org.inventario.entities.Producto;
import rmg.org.inventario.repository.UnidadMedidaRepository;
import org.springframework.data.domain.Sort;
/**
 *
 * @author loken
 */
@Service
public class ProductoService {
    
    
    private ProductoRepository productoRepository;
    private UnidadMedidaRepository medidaRepository;
    @Autowired
    public ProductoService(ProductoRepository productoRepository, UnidadMedidaRepository medidaRepository){
        this.productoRepository = productoRepository;
        this.medidaRepository = medidaRepository;
    }
    
    @Transactional
    public Optional<ProductoDTOOut> postProducto(ProductoDTOIn producto){
        Optional<UnidadMedida>getMedida = medidaRepository.findById(producto.getUnidadMedida());
        System.out.println(getMedida.isPresent());
        if(getMedida.isPresent()){
            Producto productoGuardado = productoRepository.save(new Producto(producto.getCantidad(), producto.getProducto(), getMedida.get()));
        return Optional.of(new ProductoDTOOut(productoGuardado));
        }else{
            return Optional.empty();
        }
    }
    
    public Optional<List<ProductoDTOOut>> getall(){
        List<Producto> productos= productoRepository.findAll(Sort.by(Sort.Direction.ASC, "producto"));
        List<ProductoDTOOut> productoDTOOuts= new ArrayList<>();
        
        if(productos.isEmpty()){
            return Optional.empty(); 
        }else{
            for (Producto productoDTOOut : productos) {
                productoDTOOuts.add(new ProductoDTOOut(productoDTOOut));
            }
            return Optional.of(productoDTOOuts);
        }
    }
    
    public Optional<ProductoDTOOut> getProductoById(long id){
        return Optional.of(new ProductoDTOOut(productoRepository.findById(id).get()));
    }
    
    public Optional<ProductoDTOOut> controlStock (long id, int cantidad){
        Optional<Producto> productob = productoRepository.findById(id);
        
        if(productob.isPresent()){
            Producto productoEncontrado = productob.get();
            productoEncontrado.setCantidad(cantidad);
            return Optional.of(new ProductoDTOOut(productoRepository.save(productoEncontrado)));
       }else{
            return Optional.empty();
        }
    }
}

package rmg.org.inventario.controller;

import java.util.List;
import java.util.Optional;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import rmg.org.inventario.dtos.CantidadDTO;
import rmg.org.inventario.dtos.ProductoDTOIn;
import rmg.org.inventario.dtos.ProductoDTOOut;
import rmg.org.inventario.repository.ProductoRepository;
import rmg.org.inventario.services.ProductoService;

/**
 *
 * @author loken
 */
@RestController
@RequestMapping("/productos")
public class ProductoController {
    
    private final ProductoService productoService;
    
    
    public ProductoController(ProductoService productoService){
        this.productoService = productoService;
    }
    
    @PostMapping()
    public ResponseEntity<ProductoDTOOut> save (@RequestBody ProductoDTOIn producto){
        Optional<ProductoDTOOut> nuevoProducto = productoService.postProducto(producto);
        if(nuevoProducto.isPresent()){
            return new ResponseEntity<>(nuevoProducto.get(), HttpStatus.CREATED);
        }else{
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    
    @GetMapping()
    public ResponseEntity<List<ProductoDTOOut>> getAll(){
        Optional<List<ProductoDTOOut>> productos = productoService.getall();
        if(productos.isPresent()){
            return new ResponseEntity<>(productos.get(), HttpStatus.OK);
        }else{
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<ProductoDTOOut> getById(@PathVariable long id){
        Optional<ProductoDTOOut> producto = productoService.getProductoById(id);
        if (producto.isPresent()) {
            return new ResponseEntity<>(producto.get(), HttpStatus.OK);
        }else{
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
    }
    
    @PutMapping("/agregarstok/{id}")
    public ResponseEntity<ProductoDTOOut> agregarStock(
            @PathVariable long id, @RequestBody CantidadDTO cantidad){
        Optional<ProductoDTOOut> productoCambio = productoService.controlStock(id, cantidad.getCantidad());
        if(productoCambio.isPresent()){
                return new ResponseEntity<>(productoCambio.get(), HttpStatus.OK);
        }else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}

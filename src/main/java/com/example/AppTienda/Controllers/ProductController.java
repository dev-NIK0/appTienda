package com.example.AppTienda.Controllers;

import com.example.AppTienda.Domain.DProduct;
import com.example.AppTienda.Domain.Services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping("/allproducts")
    public ResponseEntity<List<DProduct>> getAll(){
        return new ResponseEntity<>(productService.getAll(), HttpStatus.OK);
    }

    @GetMapping("/product/{id}")
    public ResponseEntity<Optional<DProduct>> getById(@PathVariable("id") Integer id){
        Optional<DProduct> product = productService.getById(id);
        if(product.isEmpty()){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);

        }else{
            return new ResponseEntity<>(HttpStatus.OK);
        }

    }

    @GetMapping("/productsByCategory/{id}")
    public ResponseEntity<Optional<List<DProduct>>> getByCategory(@PathVariable("id") Integer idCategory){

        Optional<List<DProduct>> productsCategory = productService.getByCategory(idCategory);
        if(productsCategory.isEmpty()){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }else{
            return new ResponseEntity<>(HttpStatus.OK);
        }

    }
    @PostMapping()
    public ResponseEntity<DProduct> save(@RequestBody DProduct product){
        return  new ResponseEntity<>(productService.save(product), HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable("id") Integer id){
        productService.deleteById(id);
        return new ResponseEntity<>(HttpStatus.ACCEPTED);
    }


}

package com.example.AppTienda.Domain.Services;

import com.example.AppTienda.Domain.DProduct;
import com.example.AppTienda.Persistence.Crud.RepositoriesClasses.ProductRepository;
import com.example.AppTienda.Persistence.Entities.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {
    @Autowired
    private ProductRepository productRepository;

    public List<DProduct> getAll(){
        return productRepository.getAll();
    }


    public Optional<DProduct> getById(Integer id){
        return productRepository.getById(id);
    }
    public Optional<List<DProduct>> getByCategory(Integer idCategory){
        return productRepository.getByCategory(idCategory);
    }
    public DProduct save(DProduct product){
        return productRepository.save(product);
    }
    public void deleteById(Integer id){
       productRepository.deleteById(id);
    }




}

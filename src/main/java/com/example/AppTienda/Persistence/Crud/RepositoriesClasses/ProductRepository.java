package com.example.AppTienda.Persistence.Crud.RepositoriesClasses;


import com.example.AppTienda.Domain.DProduct;
import com.example.AppTienda.Domain.Repositories.IProductRepository;
import com.example.AppTienda.Persistence.Crud.RepositoriesInterfaces.IProductRepositoryPersist;
import com.example.AppTienda.Persistence.Entities.Product;
import com.example.AppTienda.Persistence.Mappers.IProductMapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class ProductRepository implements IProductRepository {

    private IProductRepositoryPersist iProductRepository;
    private IProductMapper productMapper;


    @Override
    public List<DProduct> getAll(){
        List<Product> products = (List<Product>) iProductRepository.findAll();
        return productMapper.toDProducts(products);
    }

    @Override
    public Optional<DProduct> getById(Integer id){
        Optional<Product> product = iProductRepository.findById(id);
        return product.map(p -> productMapper.toDProduct(p));
    }

    @Override
    public Optional<List<DProduct>> getByCategory(Integer idCategory) {
        Optional<Product> products =  iProductRepository.findById(idCategory);
        return products.map(pr -> productMapper.toDProducts((List<Product>) pr));
    }

    @Override
    public DProduct save(DProduct dProduct){
        Product product = productMapper.toProduct(dProduct);
        Product savedProduct = iProductRepository.save(product);
        return productMapper.toDProduct(savedProduct);
    }


    @Override
    public void deleteById(Integer id){
        iProductRepository.deleteById(id);
    }



}

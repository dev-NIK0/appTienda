package com.example.AppTienda.Domain.Repositories;

import java.util.List;
import java.util.Optional;

import com.example.AppTienda.Domain.DProduct;
import com.example.AppTienda.Persistence.Entities.Product;

public interface IProductRepository {

    List<DProduct> getAll();
    Optional<DProduct> getById(Integer id);
    Optional<List<DProduct>> getByCategory(Integer idCategory);
    DProduct save(DProduct product);
    void deleteById(Integer id);

   /*List<DProduct> findByIdCategory(Integer id);*/



}

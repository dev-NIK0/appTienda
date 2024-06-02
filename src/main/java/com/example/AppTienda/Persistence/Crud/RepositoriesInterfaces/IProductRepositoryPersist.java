package com.example.AppTienda.Persistence.Crud.RepositoriesInterfaces;

import com.example.AppTienda.Persistence.Entities.Product;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;


import java.util.List;



public interface IProductRepositoryPersist extends CrudRepository<Product,Integer> {

    @Query("SELECT p FROM Product p WHERE p.id_product = :productId")
    Product findByIdCategory(@Param("productId") Integer id);

    @Query("SELECT p FROM Product p WHERE p.name = :productName AND p.id_category = :idCategory")
    List<Product> findByNameAndCategory(@Param("productName") String name, @Param("idCategory") Integer id_category);


}



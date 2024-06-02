package com.example.AppTienda.Persistence.Crud.RepositoriesInterfaces;

import com.example.AppTienda.Domain.DCategory;
import com.example.AppTienda.Persistence.Entities.Category;
import com.example.AppTienda.Persistence.Entities.Product;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ICategoryRepositoryPersist extends CrudRepository<Category,Integer> {

    @Query("SELECT DISTINCT c FROM Category c JOIN c.products p WHERE p IN :productsOnCategory")
    List<DCategory> findByProducts(@Param("productsOnCategory") List<Product> DProducts);


}

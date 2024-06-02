package com.example.AppTienda.Persistence.Crud.RepositoriesClasses;


import com.example.AppTienda.Domain.DCategory;
import com.example.AppTienda.Domain.DClient;
import com.example.AppTienda.Domain.Repositories.ICategoryRepository;
import com.example.AppTienda.Domain.Repositories.IClientRepository;
import com.example.AppTienda.Persistence.Crud.RepositoriesInterfaces.ICategoryRepositoryPersist;
import com.example.AppTienda.Persistence.Entities.Category;
import com.example.AppTienda.Persistence.Mappers.ICategoryMapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class CategoryRepository implements ICategoryRepository {

    private ICategoryRepositoryPersist categoryRepository;
   private ICategoryMapper categoryMapper;

    @Override
    public List<DCategory> getAll() {
        List<Category> categories = (List<Category>) categoryRepository.findAll();
        return categoryMapper.toDCategories(categories);
    }

    @Override
    public Optional<DCategory> getById(Integer id) {
        Optional<Category> category = categoryRepository.findById(id);
        return category.map(categoryMapper::toDCategory);
    }


    @Override
    public DCategory save(DCategory dCategory) {
        Category category = categoryMapper.toCategory(dCategory);
        Category savedCategory = categoryRepository.save(category);
        return categoryMapper.toDCategory(savedCategory);
    }

    @Override
    public void deleteById(Integer id) {
        categoryRepository.deleteById(id);
    }

}

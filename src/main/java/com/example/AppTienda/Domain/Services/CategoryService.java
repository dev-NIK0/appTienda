package com.example.AppTienda.Domain.Services;

import com.example.AppTienda.Domain.DCategory;
import com.example.AppTienda.Domain.Repositories.ICategoryRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryService {

    private ICategoryRepository categoryRepository;

    public List<DCategory> getAll(){
        return categoryRepository.getAll();
    }

    public  Optional<DCategory> getById(Integer id){
        return categoryRepository.getById(id);
    }
    public DCategory save(DCategory category){
        return categoryRepository.save(category);
    }
    public  void deleteById(Integer id){
        categoryRepository.deleteById(id);
    }


}

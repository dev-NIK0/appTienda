package com.example.AppTienda.Domain.Repositories;

import com.example.AppTienda.Domain.DCategory;

import java.util.List;
import java.util.Optional;

public interface ICategoryRepository {

    List<DCategory> getAll();
    Optional<DCategory> getById(Integer id);
    DCategory save(DCategory category);
    void deleteById(Integer id);


}

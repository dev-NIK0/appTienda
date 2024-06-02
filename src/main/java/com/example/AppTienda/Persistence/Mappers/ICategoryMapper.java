package com.example.AppTienda.Persistence.Mappers;

import com.example.AppTienda.Domain.DCategory;
import com.example.AppTienda.Persistence.Entities.Category;
import org.mapstruct.*;


import java.sql.DataTruncation;
import java.util.List;

@Mapper(componentModel = "spring" , uses = {IProductMapper.class})
public interface ICategoryMapper {

    @Mappings(value = {
            @Mapping(source = "idCategory", target = "categoryId"),
            @Mapping(source = "description", target = "desCategory"),
            @Mapping(source = "state", target = "stateCategory"),
    })
    DCategory toDCategory(Category category);

    List<DCategory> toDCategories(List<Category> categories);

    @InheritInverseConfiguration
    @Mappings({
            @Mapping(target = "products", ignore = true)
    })
    Category toCategory(DCategory dCategory);

    List<Category> toCategories(List<DCategory> dCategories);



}

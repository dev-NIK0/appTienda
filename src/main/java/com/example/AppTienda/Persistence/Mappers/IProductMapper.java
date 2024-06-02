package com.example.AppTienda.Persistence.Mappers;

import com.example.AppTienda.Domain.DProduct;

import com.example.AppTienda.Persistence.Entities.Product;
import org.mapstruct.*;

import java.util.List;

@Mapper(componentModel = "spring", uses = {ICategoryMapper.class})
public interface IProductMapper {
    @Mappings(value = {

            @Mapping(source = "idProduct", target = "productId"),
            @Mapping(source = "name", target = "categoryId"),
            @Mapping(source = "idCategory", target = "nameProduct"),
            @Mapping(source = "salePrice", target = "salePriceProduct"),
            @Mapping(source = "state", target = "stateProduct"),
            @Mapping(source = "category", target = "categoryProduct"),
            @Mapping(source = "products", target = "productsProduct")

    })
    DProduct toDProduct(Product product);
    List<DProduct> toDProducts(List<Product>products);

    @InheritInverseConfiguration
    @Mappings({
            @Mapping(target = "stock", ignore = true )
    })
    Product toProduct(DProduct product);
    List<Product> toProducts(List<Product> products);

}

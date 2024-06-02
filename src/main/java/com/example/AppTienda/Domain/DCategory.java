package com.example.AppTienda.Domain;

import com.example.AppTienda.Persistence.Entities.Product;
import lombok.Getter;
import lombok.Setter;

import java.util.List;


@Getter
@Setter
public class DCategory {

    private Integer categoryId;
    private String desCategory;
    private Boolean stateCategory;

    private List<Product> productsOnCategory;




}

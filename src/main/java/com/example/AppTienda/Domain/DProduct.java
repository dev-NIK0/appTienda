package com.example.AppTienda.Domain;

import com.example.AppTienda.Persistence.Entities.BuyProduct;
import com.example.AppTienda.Persistence.Entities.Category;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class DProduct {

    private Integer productId;
    private String nameProduct;

    private Integer categoryId;

    private Integer salePriceProduct;
    private Integer stockProduct;
    private Boolean stateProduct;

    private Category categoryProduct;
    private List<BuyProduct> productsProduct;

}

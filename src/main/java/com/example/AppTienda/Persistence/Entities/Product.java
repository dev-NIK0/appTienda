package com.example.AppTienda.Persistence.Entities;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
@Table(name = "products")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_product")
    private Integer idProduct;

    private String name;

    @Column(name = "id_category")
    private Integer idCategory;

    @Column(name = "sale_price")
    private Integer salePrice;

    @Column(name = "stock")
    private Integer stock;

    private Boolean state;

    @ManyToOne
    @JoinColumn(name = "id_category", insertable = false, updatable = false)
    private Category category;

    @OneToMany(mappedBy = "product")
    private List<BuyProduct> products;


}

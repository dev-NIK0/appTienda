package com.example.AppTienda.Persistence.Entities;


import jakarta.persistence.*;

@Entity
@Table(name = "buy_product")
public class BuyProduct {

    @EmbeddedId
    private BuyProductPK id;

    private Integer amount;
    private Integer total;
    private Boolean state;

    @ManyToOne
    @JoinColumn(name = "id_product", insertable = false, updatable = false)
    private Product product;

    @ManyToOne
    @JoinColumn(name = "id_buy", insertable = false, updatable = false)
    private Buy buy;



}

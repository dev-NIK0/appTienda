package com.example.AppTienda.Persistence.Entities;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Getter
@Setter
@Table(name = "buy")
public class Buy {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_buy")
    private Integer idBuy;

    @Column(name = "id_client")
    private Integer idClient;

    private LocalDateTime date;
    private String payment_method;
    private String comment ;
    private Boolean state;

    @OneToMany(mappedBy = "buy")
    private List<BuyProduct> products;

    @ManyToOne()
    @JoinColumn(name = "id_client", insertable = false, updatable = false)
    private List<Client> clients;


}

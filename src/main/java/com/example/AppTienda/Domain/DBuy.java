package com.example.AppTienda.Domain;

import com.example.AppTienda.Persistence.Entities.BuyProduct;
import com.example.AppTienda.Persistence.Entities.Client;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter

public class DBuy {

    private Integer id;
    private Integer clientId;
    private LocalDateTime dateBuy;
    private String paymentBuy;
    private String commentBuy ;
    private Boolean stateBuy ;

    private List<BuyProduct> productsBuy;

    private List<Client> clientsBuy;

}

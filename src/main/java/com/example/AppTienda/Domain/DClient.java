package com.example.AppTienda.Domain;

import com.example.AppTienda.Persistence.Entities.Buy;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class DClient {

    private Integer idClient;

    private String nameClient;
    private String lastnameClient;
    private Integer phone_numberClient;
    private String addressClient;
    private String email_addressClient;

    private List<Buy> shoppingClient;

}

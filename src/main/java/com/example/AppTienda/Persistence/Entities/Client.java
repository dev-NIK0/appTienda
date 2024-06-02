package com.example.AppTienda.Persistence.Entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
@Table(name = "clients")
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_client")
    private Integer idClient;

    private String name;
    private String lastname;
    private Integer phone_number;
    private String address;
    private String email_address;

    @OneToMany(mappedBy = "client")
    private List<Buy> shopping;



}

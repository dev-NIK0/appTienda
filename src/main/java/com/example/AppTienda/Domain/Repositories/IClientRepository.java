package com.example.AppTienda.Domain.Repositories;

import com.example.AppTienda.Domain.DClient;

import java.util.List;
import java.util.Optional;

public interface IClientRepository {

    List<DClient> getAll();
    Optional<DClient> getById(Integer id);
    DClient save(DClient client);
    void deleteById(Integer id);



}

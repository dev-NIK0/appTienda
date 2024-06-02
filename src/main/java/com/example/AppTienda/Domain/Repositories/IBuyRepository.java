package com.example.AppTienda.Domain.Repositories;

import com.example.AppTienda.Domain.DBuy;
import com.example.AppTienda.Domain.DClient;

import java.util.List;
import java.util.Optional;

public interface IBuyRepository {

    List<DBuy> getAll();
    Optional<DBuy> getById(Integer id);
    DBuy save(DBuy DBuy);
    void deleteById(Integer id);
    List<DBuy> clientList(List<DClient> clientes);


}

package com.example.AppTienda.Persistence.Crud.RepositoriesInterfaces;

import com.example.AppTienda.Persistence.Entities.Client;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface IClientRepositoryPersist extends CrudRepository<Client,Integer> {

    @Query("SELECT c FROM Client c WHERE c.id_client = :clientId")
    Client findByIdClient(@Param("clientId") Integer id);


}

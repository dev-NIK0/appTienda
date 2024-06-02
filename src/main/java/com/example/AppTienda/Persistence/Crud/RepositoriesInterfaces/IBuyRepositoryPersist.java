package com.example.AppTienda.Persistence.Crud.RepositoriesInterfaces;

import com.example.AppTienda.Persistence.Entities.Buy;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface IBuyRepositoryPersist extends CrudRepository<Buy,Integer> {

    @Query("SELECT b FROM Buy b WHERE b.payment_method = :payment")
    Buy findByPaymentMethod(@Param("payment") String paymentMethod);


    @Query("SELECT b FROM Buy b WHERE b.id_client = :buyId AND b.id_buy = :clientId")
    Buy findByIdClientAndProduct(@Param("buyId") Integer idBuy, @Param("clientId") Integer idClient);


}

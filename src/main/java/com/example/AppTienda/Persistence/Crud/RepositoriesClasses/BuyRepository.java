package com.example.AppTienda.Persistence.Crud.RepositoriesClasses;

import com.example.AppTienda.Domain.DBuy;
import com.example.AppTienda.Domain.DClient;
import com.example.AppTienda.Domain.Repositories.IBuyRepository;
import com.example.AppTienda.Persistence.Crud.RepositoriesInterfaces.IBuyRepositoryPersist;
import com.example.AppTienda.Persistence.Entities.Buy;
import com.example.AppTienda.Persistence.Mappers.IBuyMapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class BuyRepository implements IBuyRepository {

    private IBuyRepositoryPersist buyRepository;
    private IBuyMapper buyMapper;


    @Override
    public List<DBuy> getAll() {
        List<Buy> buys = (List<Buy>) buyRepository.findAll();
        return buyMapper.toDBuys(buys);
    }

    @Override
    public Optional<DBuy> getById(Integer id) {
        Optional<Buy> buy = buyRepository.findById(id);
        return buy.map(buyMapper::toDBuy);
    }

    @Override
    public DBuy save(DBuy dBuy) {
        Buy buy = buyMapper.toBuy(dBuy);
        Buy savedBuy = buyRepository.save(buy);
        return buyMapper.toDBuy(savedBuy);
    }

    @Override
    public void deleteById(Integer id) {
        buyRepository.deleteById(id);
    }

    @Override
    public List<DBuy> clientList(List<DClient> clientes) {
        return null;
    }
}

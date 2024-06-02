package com.example.AppTienda.Domain.Services;


import com.example.AppTienda.Domain.DBuy;
import com.example.AppTienda.Domain.DClient;
import com.example.AppTienda.Domain.Repositories.IBuyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BuyService {

    @Autowired
    private IBuyRepository buyRepository;

    public List<DBuy> getAll(){
        return buyRepository.getAll();
    }
    public Optional<DBuy> getById(Integer id){
        return buyRepository.getById(id);
    }
    public DBuy save(DBuy DBuy){
        return buyRepository.save(DBuy);
    }
    public void deleteById(Integer id){
        buyRepository.deleteById(id);
    }

    public List<DBuy> clientList(List<DClient> clientes){
        return buyRepository.clientList(clientes);
    }
}

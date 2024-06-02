package com.example.AppTienda.Domain.Services;

import com.example.AppTienda.Domain.DClient;
import com.example.AppTienda.Domain.Repositories.IClientRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClientService {

    private IClientRepository clientRepository;


    public List<DClient> getAll(){
        return clientRepository.getAll();
    }
    public Optional<DClient> getById(Integer id){
        return clientRepository.getById(id);
    }
    public DClient save(DClient client){
        return clientRepository.save(client);
    }
    public void deleteById(Integer id){
        clientRepository.deleteById(id);
    }

}

package com.example.AppTienda.Persistence.Crud.RepositoriesClasses;

import com.example.AppTienda.Domain.DClient;
import com.example.AppTienda.Domain.Repositories.ICategoryRepository;
import com.example.AppTienda.Domain.Repositories.IClientRepository;
import com.example.AppTienda.Persistence.Crud.RepositoriesInterfaces.IClientRepositoryPersist;
import com.example.AppTienda.Persistence.Entities.Client;
import com.example.AppTienda.Persistence.Mappers.IClientMapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class ClientRepository implements IClientRepository{

    private IClientRepositoryPersist clientRepository;
    private IClientMapper clientMapper;

    @Override
    public List<DClient> getAll() {
        Iterable<Client> clients = clientRepository.findAll();
        return clientMapper.toDClients((List<Client>) clients);
    }

    @Override
    public Optional<DClient> getById(Integer id) {
        Optional<Client> client = clientRepository.findById(id);
        return client.map(clientMapper::toDClient);
    }

    @Override
    public DClient save(DClient dClient) {
        Client client = clientMapper.toClient(dClient);
        Client savedClient = clientRepository.save(client);
        return clientMapper.toDClient(savedClient);
    }


    @Override
    public void deleteById(Integer id) {
        clientRepository.deleteById(id);
    }


}

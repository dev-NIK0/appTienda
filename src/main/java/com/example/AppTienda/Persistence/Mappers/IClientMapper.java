package com.example.AppTienda.Persistence.Mappers;

import com.example.AppTienda.Domain.DClient;
import com.example.AppTienda.Persistence.Entities.Client;
import org.mapstruct.*;

import java.util.List;

@Mapper(componentModel = "spring" , uses = {IClientMapper.class})
public interface IClientMapper {

        @Mappings(value = {
                @Mapping(source = "idClient", target = "clientId"),
                @Mapping(source = "phone_number", target = "phoneNumber"),
                @Mapping(source = "email_address", target = "emailAddress"),
                @Mapping(source = "shopping", target = "shopping"),
        })
        DClient toDClient(Client client);
        List<DClient> toDClients(List<Client> clients);

        @InheritInverseConfiguration
        @Mappings({
                @Mapping(target = "shopping", ignore = true)
        })
        Client toClient(DClient dClient);
        List<Client> toClients(List<Client> dClients);


}

package com.example.AppTienda.Persistence.Mappers;

import com.example.AppTienda.Domain.DBuy;
import com.example.AppTienda.Persistence.Entities.Buy;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring", uses = {IClientMapper.class,IProductMapper.class})
public interface IBuyMapper {


        @Mappings(value = {
                @Mapping(source = "idBuy", target = "id"),
                @Mapping(source = "idClient", target = "clientId"),
                @Mapping(source = "date", target = "dateBuy"),
                @Mapping(source = "payment_method", target = "payment_buy"),
                @Mapping(source = "state", target = "stateBuy"),
                @Mapping(source = "products", target = "productsBuy"),
                @Mapping(source = "clients", target = "clientsBuy"),
        })
        DBuy toDBuy(Buy buy);
        List<DBuy> toDBuys(List<Buy> buys);

        @InheritInverseConfiguration
        @Mappings({
                @Mapping(target = "comment", ignore = true)
        })
        Buy toBuy(DBuy dBuy);
        List<Buy> toBuys(List<DBuy> buys);

}

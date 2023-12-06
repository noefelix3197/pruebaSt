package com.bbva.mapper;

import com.bbva.dto.ClientDTO;
import com.bbva.model.Client;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;
@Mapper(componentModel = MappingConstants.ComponentModel.SPRING, uses = {DocumentTypeMapper.class, AccountMapper.class})
public interface ClientMapper {

    ClientDTO mapToClientDto(Client client);

    Client mapToClient(ClientDTO clientDTO);
}

package com.bbva.service;

import com.bbva.dto.ClientDTO;
import com.bbva.model.Client;

public interface IClientService extends ICRUD<Client, Integer>{
    public Client saveDTO(ClientDTO clientDTO);
}

package com.bbva.controller;

import com.bbva.dto.ClientDTO;
import com.bbva.mapper.ClientMapper;
import com.bbva.model.Client;
import com.bbva.service.IClientService;
import jakarta.validation.Valid;
import org.apache.catalina.connector.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.IllegalFormatCodePointException;

@RestController
@RequestMapping("/clients")
public class ClientController {
    @Autowired
    private IClientService serviceClient;

    @Autowired
    private ClientMapper clientMapper;
    @GetMapping
    public ResponseEntity<ClientDTO> findById(@RequestParam(value = "idClient") Integer idClient){
        Client client = serviceClient.findById(idClient);
        ClientDTO clientDTO = clientMapper.mapToClientDto(client);

        return new ResponseEntity<>(clientDTO, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<ClientDTO> save(@Valid @RequestBody ClientDTO clientDTO){
        Client client = serviceClient.saveDTO(clientDTO);

        ClientDTO obj = clientMapper.mapToClientDto(client);
        if (client == null || client.getIdClient() == 0){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(obj, HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<ClientDTO> update(@Valid @RequestBody ClientDTO clientDTO){
        Client client = serviceClient.save(clientMapper.mapToClient(clientDTO));
        ClientDTO obj = clientMapper.mapToClientDto(client);
        return new ResponseEntity<>(obj, HttpStatus.CREATED);
    }


}

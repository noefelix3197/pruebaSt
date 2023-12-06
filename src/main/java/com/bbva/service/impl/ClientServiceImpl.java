package com.bbva.service.impl;

import com.bbva.dto.CardDTO;
import com.bbva.dto.ClientDTO;
import com.bbva.mapper.ClientMapper;
import com.bbva.model.Account;
import com.bbva.model.Card;
import com.bbva.model.Client;
import com.bbva.repository.IClientRepository;
import com.bbva.repository.IGenericRepository;
import com.bbva.service.IClientService;
import org.hibernate.dialect.Database;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.ArrayList;
import java.util.List;

@Service
public class ClientServiceImpl extends CRUDimpl<Client, Integer> implements IClientService {

    @Autowired
    private IClientRepository repository;

    @Override
    protected IGenericRepository<Client, Integer> getRepository() {
        return repository;
    }

    @Autowired
    ClientMapper clientMapper;
    @Override
    public Client saveDTO(ClientDTO client) {

        if (client.getAccounts().get(0).getAmount()<50.00){
            return null;
        }
        int numero = (int)(Math.random()*(9999999)+999999);
        client.getAccounts().get(0).setAccountNumber("191001"+numero);

        CardDTO card = new CardDTO();
        card.setCardNumber("xxxx-XXXX-XXXX-XXXX");
        card.setCardType("DEBITO");
        String dueDate = LocalDateTime.now().getMonthValue()+"/"+LocalDateTime.now().plusYears(5).getYear();
        card.setDueDate(dueDate);
        int ccv = (int)(Math.random()*(999)+1);
        String ccvS = ("000"+ccv);
        card.setCcv(ccvS.substring(ccvS.length()-3));
        //client.getAccounts().get(0).setClient(client);
        card.setAccount(client.getAccounts().get(0));
        List<CardDTO> cards = new ArrayList<>();
        cards.add(card);
        client.getAccounts().get(0).setCards(cards);

        Client obj = clientMapper.mapToClient(client);
        obj.getAccounts().get(0).setClient(obj);
        obj.getAccounts().get(0).getCards().get(0).setAccount(obj.getAccounts().get(0));
        return super.save(obj);
    }
}

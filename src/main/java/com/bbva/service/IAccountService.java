package com.bbva.service;

import com.bbva.dto.ClientDTO;
import com.bbva.model.Account;
import com.bbva.model.Client;

import java.util.List;

public interface IAccountService extends ICRUD<Account, Integer> {
    List<Account> getAccountByIdClient(Integer idClient);
}

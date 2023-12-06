package com.bbva.service.impl;

import com.bbva.model.Account;
import com.bbva.repository.IAccountRepository;
import com.bbva.repository.IGenericRepository;
import com.bbva.service.IAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccountServiceImpl extends CRUDimpl<Account, Integer> implements IAccountService {
    @Autowired
    private IAccountRepository repository;

    @Override
    protected IGenericRepository<Account, Integer> getRepository() {
        return repository;
    }

    @Override
    public List<Account> getAccountByIdClient(Integer idClient) {
        return repository.getAccountByIdClient(idClient);
    }
}

package com.bbva.service.impl;

import com.bbva.model.AccountType;
import com.bbva.repository.IAccountRepository;
import com.bbva.repository.IAccountTypeRepository;
import com.bbva.repository.IGenericRepository;
import com.bbva.service.IAccountTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccountTypeServiceImpl extends CRUDimpl<AccountType, Integer> implements IAccountTypeService {

    @Autowired
    private IAccountTypeRepository repository;

    @Override
    protected IGenericRepository<AccountType, Integer> getRepository() {
        return repository;
    }
}

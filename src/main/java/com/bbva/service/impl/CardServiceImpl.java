package com.bbva.service.impl;

import com.bbva.model.Card;
import com.bbva.repository.ICardRepository;
import com.bbva.repository.IGenericRepository;
import com.bbva.service.ICardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CardServiceImpl extends CRUDimpl<Card, Integer> implements ICardService {
    @Autowired
    private ICardRepository repository;

    @Override
    protected IGenericRepository<Card, Integer> getRepository() {
        return repository;
    }
}

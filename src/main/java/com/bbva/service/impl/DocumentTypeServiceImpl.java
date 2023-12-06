package com.bbva.service.impl;

import com.bbva.model.DocumentType;
import com.bbva.repository.IDocumentTypeRepository;
import com.bbva.repository.IGenericRepository;
import com.bbva.service.IDocumentTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DocumentTypeServiceImpl extends CRUDimpl<DocumentType,Integer> implements IDocumentTypeService {

    @Autowired
    private IDocumentTypeRepository repository;

    @Override
    protected IGenericRepository<DocumentType, Integer> getRepository() {
        return repository;
    }
}

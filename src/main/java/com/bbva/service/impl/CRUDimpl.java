package com.bbva.service.impl;

import com.bbva.repository.IGenericRepository;
import com.bbva.service.ICRUD;

import java.util.List;

public abstract class CRUDimpl<T, ID> implements ICRUD<T, ID> {
    protected abstract IGenericRepository<T,ID> getRepository();

    @Override
    public T save(T t) {
        return getRepository().save(t);
    }

    @Override
    public T update(T t) {
        return getRepository().save(t);
    }

    @Override
    public List<T> findAll() {
        return getRepository().findAll();
    }

    @Override
    public T findById(ID id) {
        return getRepository().findById(id).orElse(null);
    }

    @Override
    public void delete(ID id) {
        getRepository().deleteById(id);
    }
}

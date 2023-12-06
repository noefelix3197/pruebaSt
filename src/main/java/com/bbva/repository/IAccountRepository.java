package com.bbva.repository;

import com.bbva.model.Account;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface IAccountRepository extends IGenericRepository<Account, Integer>{

    @Query("from Account a where a.client.idClient = :idClient")
    List<Account> getAccountByIdClient(@Param("idClient") Integer idClient);
}

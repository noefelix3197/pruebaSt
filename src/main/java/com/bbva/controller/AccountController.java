package com.bbva.controller;

import com.bbva.dto.AccountDTO;
import com.bbva.mapper.AccountMapper;
import com.bbva.model.Account;
import com.bbva.service.IAccountService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/accounts")

public class AccountController {

    @Autowired
    private IAccountService accountService;
    @Autowired
    private AccountMapper accountMapper;
    @DeleteMapping
    public ResponseEntity<Void> delete(@RequestParam(value = "idAccount") Integer idAccount ){

        accountService.delete(idAccount);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PostMapping
    public ResponseEntity<AccountDTO> save(@Valid @RequestBody AccountDTO dto){

        Account account = accountService.save(accountMapper.mapToAccount(dto));

        return new ResponseEntity<>(accountMapper.mapToAccountDto(account),HttpStatus.CREATED);
    }
    @GetMapping("/lista")
    public ResponseEntity<List<AccountDTO>> getAccountsById(@RequestParam(value = "idClient") Integer idClient ){
        List<AccountDTO> obj = accountMapper.mapToAccountDtoList(accountService.getAccountByIdClient(idClient));
        return new ResponseEntity<>(obj, HttpStatus.OK);
    }
}

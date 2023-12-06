package com.bbva.dto;

import com.bbva.model.AccountType;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class AccountDTO {
    @EqualsAndHashCode.Include
    private Integer idAccount;
    private String accountNumber;
    private Double amount;
    private AccountTypeDTO accountType;
    @JsonManagedReference
    private List<CardDTO> cards;
    @JsonBackReference
    private ClientDTO client;
}

package com.bbva.mapper;

import com.bbva.dto.AccountDTO;
import com.bbva.model.Account;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;

import java.util.List;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING, uses = {CardMapper.class, AccountTypeMapper.class})
public interface AccountMapper {

    @Mapping(ignore = true, target = "client")
    AccountDTO mapToAccountDto(Account account);
    @Mapping(ignore = true, target = "client")
    Account mapToAccount(AccountDTO accountDTO);


    List<Account> mapToAccountList(List<AccountDTO> accountDTOS);
    List<AccountDTO> mapToAccountDtoList(List<Account> accounts);
}

package com.bbva.mapper;

import com.bbva.dto.AccountTypeDTO;
import com.bbva.model.AccountType;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface AccountTypeMapper {

    AccountTypeDTO mapToAccountTypeDto(AccountType accountType);
    AccountType mapToAccountType(AccountTypeDTO accountTypeDTO);
}

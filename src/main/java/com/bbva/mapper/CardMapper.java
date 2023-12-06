package com.bbva.mapper;

import com.bbva.dto.CardDTO;
import com.bbva.model.Card;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface CardMapper {
    @Mapping(ignore = true, target = "account")
    CardDTO mapToCardDto(Card card);
    @Mapping(ignore = true, target = "account")
    Card mapToCard(CardDTO cardDTO);
}

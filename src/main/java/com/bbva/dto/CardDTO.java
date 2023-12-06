package com.bbva.dto;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class CardDTO {
    @EqualsAndHashCode.Include
    private Integer idCard;
    private String cardType;
    private String dueDate;
    private String ccv;
    private String cardNumber;
    @JsonBackReference
    private AccountDTO account;
}

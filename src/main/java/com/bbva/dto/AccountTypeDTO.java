package com.bbva.dto;

import jakarta.persistence.Column;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class AccountTypeDTO {
    @EqualsAndHashCode.Include
    private Integer idAccountType;
    private String name;
}

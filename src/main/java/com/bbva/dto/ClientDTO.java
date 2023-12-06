package com.bbva.dto;

import com.bbva.model.DocumentType;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class ClientDTO {
    @EqualsAndHashCode.Include
    private Integer idClient;
    private String firstName;
    private String lastName;
    private DocumentTypeDTO documentType;
    private String documentNumber;
    private String address;
    private String phone;
    private String email;
    private LocalDateTime bornDate;
    @JsonManagedReference
    private List<AccountDTO> accounts;
}

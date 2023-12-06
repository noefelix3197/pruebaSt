package com.bbva.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class DocumentTypeDTO {
    @EqualsAndHashCode.Include
    private Integer idDocumentType;
    private String name;
}

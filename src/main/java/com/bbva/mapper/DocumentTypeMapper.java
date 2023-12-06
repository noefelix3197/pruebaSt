package com.bbva.mapper;

import com.bbva.dto.DocumentTypeDTO;
import com.bbva.model.DocumentType;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface DocumentTypeMapper {

    DocumentTypeDTO mapToDocumentTypeDto(DocumentType documentType);
    DocumentType mapToDocumentType(DocumentTypeDTO documentTypeDTO);
}

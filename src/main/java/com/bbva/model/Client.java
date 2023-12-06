package com.bbva.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity

public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Integer idClient;
    @Column
    private String firstName;
    @Column
    private String lastName;
    @ManyToOne
    @JoinColumn(name="id_document_type", nullable = false, foreignKey = @ForeignKey(name = "FK_CLIENT_DOCUMENT_TYPE"))
    private DocumentType documentType;
    @Column
    private String documentNumber;
    @Column
    private String address;
    @Column
    private String phone;
    @Column
    private String email;
    @Column
    private LocalDateTime bornDate;

    @JsonManagedReference
    @OneToMany(mappedBy = "client", cascade = {CascadeType.ALL}, orphanRemoval = true, fetch = FetchType.EAGER)
    private List<Account> accounts;
}

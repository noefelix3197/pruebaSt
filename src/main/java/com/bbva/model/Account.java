package com.bbva.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)

@Entity
public class Account {
    @Id
    @EqualsAndHashCode.Include
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idAccount;
    @Column
    private String accountNumber;
    @Column
    private Double amount;
    @ManyToOne
    @JoinColumn(name="id_account_type", nullable = false, foreignKey = @ForeignKey(name = "FK_ACCOUNT_TYPE"))
    private AccountType accountType;

    @JsonManagedReference
    @OneToMany(mappedBy = "account", cascade = {CascadeType.ALL}, orphanRemoval = true,fetch = FetchType.EAGER)
    private List<Card> cards;

    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "id_client", nullable = false, foreignKey = @ForeignKey(name = "FK_CLIENT_ACCOUNT"))
    private Client client;
}

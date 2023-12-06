package com.bbva.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity

public class Card {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Integer idCard;
    @Column
    private String cardType;
    @Column
    private String dueDate;
    @Column
    private String ccv;
    @Column
    private String cardNumber;

    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "id_account", nullable = false, foreignKey = @ForeignKey(name = "FK_CARD_ACOUNT"))
    private Account account;

}

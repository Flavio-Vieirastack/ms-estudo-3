package com.mscartoes.mscartoes.Models;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Entity
@Data
@NoArgsConstructor
public class ClientCard {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false, length = 11)
    private String cpf;
    @ManyToOne()
    @JoinColumn(name = "card_id", nullable = false)
    private CardModel cardModel;
    @Column(nullable = false, length = 10)
    private BigDecimal approvedIncome;

    public ClientCardDTO toDTO() {
        return new ClientCardDTO(
                cardModel.getName(),
                cardModel.getCardFlag(),
                cardModel.getIncome()
        );
    }
}

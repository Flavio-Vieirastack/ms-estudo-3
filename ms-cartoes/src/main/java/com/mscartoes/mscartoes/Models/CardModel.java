package com.mscartoes.mscartoes.Models;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@Entity
@NoArgsConstructor
@Table(name = "card")
public class CardModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false, length = 50)
    private String name;
    @Enumerated(EnumType.STRING)
    private CardFlag cardFlag;
    @Column(nullable = false, length = 10)
    private BigDecimal income;
    @Column(nullable = false, length = 10)
    private BigDecimal basicLimit;

    public CardModel(String name,
                     CardFlag cardFlag,
                     BigDecimal income,
                     BigDecimal basicLimit) {
        this.name = name;
        this.cardFlag = cardFlag;
        this.income = income;
        this.basicLimit = basicLimit;
    }
}

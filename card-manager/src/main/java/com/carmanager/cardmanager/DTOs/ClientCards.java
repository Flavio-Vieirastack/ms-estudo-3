package com.carmanager.cardmanager.DTOs;

import java.math.BigDecimal;

public record ClientCards(
        String name,
        String cardFlag,
        BigDecimal basicLimit
) { //parei em 5 min e 30 da aula 23
}

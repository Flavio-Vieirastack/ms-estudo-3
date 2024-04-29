package com.carmanager.cardmanager.DTOs;

import java.math.BigDecimal;

public record CardData(
        Long id,
        String name,
        String flag,
        BigDecimal basicIncome
) {
}

package com.carmanager.cardmanager.DTOs;

import java.math.BigDecimal;

public record ApprovedCards(
        String name,
        String flag,
        BigDecimal approvedLimit
) {
}

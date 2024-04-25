package com.mscartoes.mscartoes.Models;

import java.math.BigDecimal;

public record CardDTO(
        String name,
        CardFlag cardFlag,
        BigDecimal income,
        BigDecimal basicLimit
) {
}

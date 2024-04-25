package com.mscartoes.mscartoes.Models;

import java.math.BigDecimal;

public record ClientCardDTO(
        String name,
        CardFlag cardFlag,
        BigDecimal limit
) {
}

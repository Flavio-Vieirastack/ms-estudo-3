package com.carmanager.cardmanager.DTOs;

import java.util.Set;

public record ClientAvaliationResult(
    Set<ApprovedCards> approvedCards
) {
}

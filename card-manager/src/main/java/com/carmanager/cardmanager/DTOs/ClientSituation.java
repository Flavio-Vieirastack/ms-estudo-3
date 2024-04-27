package com.carmanager.cardmanager.DTOs;

import java.util.Set;

public record ClientSituation(
        ClientData clientData,
        Set<ClientCards> clientSituations
) {

}

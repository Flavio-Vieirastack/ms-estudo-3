package com.carmanager.cardmanager.Service;

import com.carmanager.cardmanager.DTOs.ClientSituation;
import com.carmanager.cardmanager.RestClients.ClientResources;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;

@Service
public class CardManagerService {

    @Autowired
    private ClientResources clientResources;

    public ClientSituation getClientSituation(String cpf) {
        var clientData = clientResources.findByCpf(cpf);
        return new ClientSituation(
                clientData.getBody(),
                new HashSet<>()
        );
    }
}

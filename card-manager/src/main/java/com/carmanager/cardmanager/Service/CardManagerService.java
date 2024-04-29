package com.carmanager.cardmanager.Service;

import com.carmanager.cardmanager.DTOs.ApprovedCards;
import com.carmanager.cardmanager.DTOs.ClientAvaliationResult;
import com.carmanager.cardmanager.DTOs.ClientCards;
import com.carmanager.cardmanager.DTOs.ClientSituation;
import com.carmanager.cardmanager.RestClients.CardResources;
import com.carmanager.cardmanager.RestClients.ClientResources;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
public class CardManagerService {

    @Autowired
    private ClientResources clientResources;

    @Autowired
    private CardResources cardResources;

    public ClientSituation getClientSituation(String cpf) {
        var clientData = clientResources.findByCpf(cpf);
        var card = new HashSet<>(Objects.requireNonNull(cardResources.getCardByCpf(cpf).getBody()));
        return new ClientSituation(
                clientData.getBody(),
                card
        );
    }

    public ClientAvaliationResult makeAvaliation(String cpf, Long income) {
        var client = clientResources.findByCpf(cpf).getBody();
        var cards = cardResources.getCardByIncome(income).stream().map(
                card -> {
                    var basicLimit = card.basicIncome();
                    var ageBigDecimal = BigDecimal.valueOf(client.age());
                    BigDecimal factor = ageBigDecimal.divide(BigDecimal.valueOf(10));
                    var limit = factor.multiply(basicLimit);
                    return new ApprovedCards(
                            card.name(),
                            card.flag(),
                            limit
                    );
                }
        ).collect(Collectors.toSet());
        return new ClientAvaliationResult(
                cards
        );
    }
}

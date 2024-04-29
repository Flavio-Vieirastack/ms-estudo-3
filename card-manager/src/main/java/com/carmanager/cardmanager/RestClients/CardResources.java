package com.carmanager.cardmanager.RestClients;

import com.carmanager.cardmanager.DTOs.CardData;
import com.carmanager.cardmanager.DTOs.ClientCards;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@FeignClient(value = "ms-cards", path = "/cards")
@Component
public interface CardResources {
    @GetMapping(params = "cpf")
    ResponseEntity<List<ClientCards>> getCardByCpf(
            @RequestParam String cpf);
    @GetMapping("{income}")
    List<CardData> getCardByIncome(@PathVariable Long income);
}

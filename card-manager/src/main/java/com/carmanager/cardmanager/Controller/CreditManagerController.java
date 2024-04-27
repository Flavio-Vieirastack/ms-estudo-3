package com.carmanager.cardmanager.Controller;

import com.carmanager.cardmanager.DTOs.ClientSituation;
import com.carmanager.cardmanager.Service.CardManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/card-manager")
public class CreditManagerController {

    @Autowired
    private CardManagerService cardManagerService;

    @GetMapping
    public String status() {
        return "Ok";
    }

    @GetMapping("client-situation")
    public ResponseEntity<ClientSituation> getClientSituation(@RequestParam String cpf) {
        return ResponseEntity.ok(cardManagerService.getClientSituation(cpf));
    }
}

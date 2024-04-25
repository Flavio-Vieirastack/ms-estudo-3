package com.mscartoes.mscartoes.Controllers;

import com.mscartoes.mscartoes.Models.CardDTO;
import com.mscartoes.mscartoes.Models.CardModel;
import com.mscartoes.mscartoes.Models.ClientCardDTO;
import com.mscartoes.mscartoes.Service.CardService;
import com.mscartoes.mscartoes.Service.ClientCardService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cards")
public class CardsController {

    @Autowired
    private ClientCardService clientCardService;

    @Autowired
    private CardService cardService;


    @GetMapping("/status")
    public String status() {
        return "Ok";
    }

    @PostMapping
    public ResponseEntity<CardModel> create(@RequestBody CardDTO cardDTO) {
        var cardModel = new CardModel();
        BeanUtils.copyProperties(cardDTO, cardModel);
        return ResponseEntity.status(HttpStatus.CREATED).body(
                cardService.save(cardModel));
    }

    @GetMapping("{income}")
    public List<CardModel> getCardByIncome(@PathVariable Long income) {
        return cardService.getCardIncomeLessThan(income);
    }

    @GetMapping(params = "cpf")
    public ResponseEntity<List<ClientCardDTO>> getCardByCpf(
            @RequestParam String cpf) {
        return ResponseEntity.ok(clientCardService.getByCpf(cpf));
    }
}

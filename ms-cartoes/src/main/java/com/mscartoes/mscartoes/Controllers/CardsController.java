package com.mscartoes.mscartoes.Controllers;

import com.mscartoes.mscartoes.Models.CardDTO;
import com.mscartoes.mscartoes.Models.CardModel;
import com.mscartoes.mscartoes.Service.CardService;
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

    @GetMapping()
    public List<CardModel> getCardByIncome(Long income) {
        return cardService.getCardIncomeLessThan(income);
    }
}

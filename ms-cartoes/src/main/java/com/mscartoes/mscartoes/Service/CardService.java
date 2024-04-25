package com.mscartoes.mscartoes.Service;

import com.mscartoes.mscartoes.Models.CardModel;
import com.mscartoes.mscartoes.Repositories.CardRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public class CardService {
    @Autowired
    private CardRepository cardRepository;

    @Transactional
    public CardModel save(CardModel cardModel) {
        return cardRepository.save(cardModel);
    }
    
    public List<CardModel> getCardIncomeLessThan(Long income) {
        var incomeDecimal = BigDecimal.valueOf(income);
        return cardRepository.getByIncomeLessThanEqual(incomeDecimal);
    }
}

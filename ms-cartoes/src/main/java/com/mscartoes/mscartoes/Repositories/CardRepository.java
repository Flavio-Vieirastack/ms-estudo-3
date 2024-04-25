package com.mscartoes.mscartoes.Repositories;

import com.mscartoes.mscartoes.Models.CardModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;

@Repository
public interface CardRepository extends JpaRepository<CardModel, Long> {
    List<CardModel> getByIncomeLessThanEqual(BigDecimal income);
}

package com.mscartoes.mscartoes.Repositories;

import com.mscartoes.mscartoes.Models.ClientCard;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ClientCardRepository extends JpaRepository<ClientCard, Long> {
    List<ClientCard> getByCpf(String cpf);
}

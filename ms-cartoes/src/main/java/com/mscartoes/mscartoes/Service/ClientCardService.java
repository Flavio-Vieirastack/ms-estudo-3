package com.mscartoes.mscartoes.Service;

import com.mscartoes.mscartoes.Models.ClientCard;
import com.mscartoes.mscartoes.Models.ClientCardDTO;
import com.mscartoes.mscartoes.Repositories.ClientCardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClientCardService {
    @Autowired
    private ClientCardRepository clientCardRepository;

    public List<ClientCardDTO> getByCpf(String cpf) {
        return clientCardRepository.getByCpf(cpf).stream().map(
                ClientCard::toDTO
        ).toList();
    }
}

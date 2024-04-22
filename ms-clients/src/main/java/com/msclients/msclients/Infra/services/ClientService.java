package com.msclients.msclients.Infra.services;

import com.msclients.msclients.Core.Utils.ApiObjectMapper;
import com.msclients.msclients.Infra.repositories.ClientRepository;
import com.msclients.msclients.domain.DTOs.ClientDTO;
import com.msclients.msclients.domain.models.ClientModel;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClientService {
    @Autowired
    private ClientRepository clientRepository;

    @Autowired
    private ApiObjectMapper<ClientModel> apiObjectMapper;

    @Transactional
    public ClientModel create(ClientDTO clientDTO) {
        var clientModel = apiObjectMapper.dtoToModel(clientDTO, ClientModel.class);
        return clientRepository.save(clientModel);
    }

    public ClientModel getByCpf(String cpf) {
        return clientRepository.findClientModelByCpf(cpf).orElseThrow(
                ()-> new RuntimeException("Not found")
        );
    }

}

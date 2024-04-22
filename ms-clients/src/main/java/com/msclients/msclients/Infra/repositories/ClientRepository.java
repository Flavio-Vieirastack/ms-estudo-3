package com.msclients.msclients.Infra.repositories;

import com.msclients.msclients.domain.models.ClientModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ClientRepository extends JpaRepository<ClientModel, Long> {
    Optional<ClientModel> findClientModelByCpf(String cpf);
}

package com.carmanager.cardmanager.RestClients;

import com.carmanager.cardmanager.DTOs.ClientData;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(value = "ms-clients", path = "/clients")
@Component
public interface ClientResources {
    @GetMapping("{cpf}")
    ResponseEntity<ClientData> findByCpf(@PathVariable String cpf);
}

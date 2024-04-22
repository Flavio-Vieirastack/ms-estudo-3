package com.msclients.msclients.Controllers;

import com.msclients.msclients.Infra.services.ClientService;
import com.msclients.msclients.domain.DTOs.ClientDTO;
import com.msclients.msclients.domain.models.ClientModel;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.TimeUnit;

@RestController
@RequestMapping("/clients")
public class ClientController {

    @PostConstruct
    private void onInit() throws Exception {
        TimeUnit.SECONDS.sleep(1);
        var client = new ClientDTO(
                "04867792381",
                "Flavio emerson",
                33
        );
        create(client);
    }

    @Autowired
    private ClientService clientService;

    @GetMapping("/status")
    public String status() {
        return "Ok";
    }

    @PostMapping
    public ResponseEntity<ClientModel> create(@RequestBody ClientDTO clientDTO) {
        return ResponseEntity.status(HttpStatus.CREATED).body(
                clientService.create(clientDTO)
        );
    }

    @GetMapping("{cpf}")
    public ResponseEntity<ClientModel> findByCpf(@PathVariable String cpf) {
        return ResponseEntity.ok(
                clientService.getByCpf(cpf)
        );
    }
}

package com.cm.clientservice.controller;

import com.cm.clientservice.dto.ClientRequestDto;
import com.cm.clientservice.dto.ClientResponseDto;
import com.cm.clientservice.service.ClientService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/clients")
public class ClientController {
    /* client controller dependent on client service
    *   use dependency injection to inject client service to controller
    *  */

    private final ClientService clientService;

    public ClientController(ClientService clientService) {
        this.clientService = clientService;
    }

    @GetMapping
    public ResponseEntity<List<ClientResponseDto>> getClients() {
        List<ClientResponseDto> clients = clientService.getClients();

        return ResponseEntity.ok().body(clients);
    }

    @PostMapping
    public ResponseEntity<ClientResponseDto> createClient(@Valid @RequestBody ClientRequestDto clientRequestDto) {
        ClientResponseDto clientResponseDto = clientService.createClient(clientRequestDto);

        return ResponseEntity.ok().body(clientResponseDto);
    }
}

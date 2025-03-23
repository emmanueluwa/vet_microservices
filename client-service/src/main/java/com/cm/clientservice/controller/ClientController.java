package com.cm.clientservice.controller;

import com.cm.clientservice.dto.ClientRequestDto;
import com.cm.clientservice.dto.ClientResponseDto;
import com.cm.clientservice.dto.validators.CreateClientValidationGroup;
import com.cm.clientservice.service.ClientService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import jakarta.validation.groups.Default;
import org.apache.coyote.Response;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/clients")
@Tag(name="Client", description="API for managing Clients")
public class ClientController {
    /* client controller dependent on client service
    *   use dependency injection to inject client service to controller
    *  */

    private final ClientService clientService;

    public ClientController(ClientService clientService) {
        this.clientService = clientService;
    }

    @GetMapping
    @Operation(summary="Get Clients")
    public ResponseEntity<List<ClientResponseDto>> getClients() {
        List<ClientResponseDto> clients = clientService.getClients();

        return ResponseEntity.ok().body(clients);
    }

    @PostMapping
    @Operation(summary="Create a new Client")
    public ResponseEntity<ClientResponseDto> createClient(@Validated({Default.class, CreateClientValidationGroup.class}) @RequestBody ClientRequestDto clientRequestDto) {
        ClientResponseDto clientResponseDto = clientService.createClient(clientRequestDto);

        return ResponseEntity.ok().body(clientResponseDto);
    }

    @PutMapping("/{id}")
    @Operation(summary="Update a Client")
    public ResponseEntity<ClientResponseDto> updateClient(@PathVariable UUID id, @Validated({Default.class}) @RequestBody ClientRequestDto clientRequestDto) {
        ClientResponseDto clientResponseDto = clientService.updateClient(id, clientRequestDto);

        return ResponseEntity.ok().body(clientResponseDto);
    }

    @DeleteMapping("/{id}")
    @Operation(summary="Delete a Client")
    public ResponseEntity<Void> deleteClient(@PathVariable UUID id) {
        clientService.deleteClient(id);

        return ResponseEntity.noContent().build();
    }
}

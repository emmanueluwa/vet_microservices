package com.cm.clientservice.service;

import com.cm.clientservice.dto.ClientRequestDto;
import com.cm.clientservice.dto.ClientResponseDto;
import com.cm.clientservice.mapper.ClientMapper;
import com.cm.clientservice.model.Client;
import com.cm.clientservice.repository.ClientRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ClientService {
    private ClientRepository clientRepository;

    public ClientService(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    public List<ClientResponseDto> getClients() {
        List<Client> clients = clientRepository.findAll();

        return clients.stream().map(ClientMapper::toDto).toList();
    }

    public ClientResponseDto createClient(ClientRequestDto clientRequestDto) {
        Client newClient = clientRepository.save(ClientMapper.toModel(clientRequestDto));

        return ClientMapper.toDto(newClient);
    }
}

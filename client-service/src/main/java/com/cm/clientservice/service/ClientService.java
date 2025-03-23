package com.cm.clientservice.service;

import com.cm.clientservice.dto.ClientRequestDto;
import com.cm.clientservice.dto.ClientResponseDto;
import com.cm.clientservice.exception.ClientNotFoundException;
import com.cm.clientservice.exception.EmailAlreadyExistsException;
import com.cm.clientservice.mapper.ClientMapper;
import com.cm.clientservice.model.Client;
import com.cm.clientservice.repository.ClientRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

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
        if(clientRepository.existsByEmail(clientRequestDto.getEmail())) {
            throw new EmailAlreadyExistsException("A patient with this email "+"already exists"+clientRequestDto.getEmail());
        }

        Client newClient = clientRepository.save(ClientMapper.toModel(clientRequestDto));

        return ClientMapper.toDto(newClient);
    }

    public ClientResponseDto updateClient(UUID id, ClientRequestDto clientRequestDto) {
        Client client = clientRepository.findById(id).orElseThrow(
                () -> new ClientNotFoundException("No client with given id was found: "+ id)
        );

        if(clientRepository.existsByEmailAndIdNot(clientRequestDto.getEmail(), id)) {
            throw new EmailAlreadyExistsException("A patient with this email "+"already exists"+clientRequestDto.getEmail());
        }

        client.setName(clientRequestDto.getName());
        client.setAddress(clientRequestDto.getAddress());
        client.setEmail(clientRequestDto.getEmail());
        client.setDateOfBirth(LocalDate.parse(clientRequestDto.getDateOfBirth()));

        Client clientUpdated = clientRepository.save(client);

        return ClientMapper.toDto(clientUpdated);
    }
}

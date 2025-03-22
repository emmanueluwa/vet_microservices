package com.cm.clientservice.mapper;

import com.cm.clientservice.dto.ClientRequestDto;
import com.cm.clientservice.dto.ClientResponseDto;
import com.cm.clientservice.model.Client;

import java.time.LocalDate;

public class ClientMapper {
    public static ClientResponseDto toDto(Client client) {
        ClientResponseDto clientDto = new ClientResponseDto();

        clientDto.setId(client.getId().toString());
        clientDto.setName(client.getName());
        clientDto.setAddress(client.getAddress());
        clientDto.setEmail(client.getEmail());
        clientDto.setDateOfBirth(client.getDateOfBirth().toString());

        return clientDto;
    }

    public static Client toModel(ClientRequestDto clientRequestDto) {
        Client client = new Client();
        client.setName(clientRequestDto.getName());
        client.setAddress(clientRequestDto.getAddress());
        client.setEmail(clientRequestDto.getEmail());
        client.setDateOfBirth(LocalDate.parse(clientRequestDto.getDateOfBirth()));
        client.setRegisteredDate(LocalDate.parse(clientRequestDto.getRegisteredDate()));

        return client;
    }
}

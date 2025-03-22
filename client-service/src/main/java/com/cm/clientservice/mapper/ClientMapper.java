package com.cm.clientservice.mapper;

import com.cm.clientservice.dto.ClientResponseDto;
import com.cm.clientservice.model.Client;

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
}

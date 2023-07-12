package domain.mapping.dtos;

import domain.enums.ClientType;

public record ClientDto(String identifier,
                        String fullName,
                        String email,
                        ClientType clientType,
                        String cellphone) {
}


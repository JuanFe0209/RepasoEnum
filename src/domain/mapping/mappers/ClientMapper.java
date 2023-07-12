package domain.mapping.mappers;
import domain.mapping.dtos.ClientDto;
import domain.models.Client;

import java.util.List;
import java.util.stream.Collectors;

public class ClientMapper {
    public static ClientDto mapFrom(Client source){
        return new ClientDto(source.getIdentifeir(),
                source.getFullName(),
                source.getEmail(),
                source.getType(),
                source.getContact());
    }
    public static Client mapFrom(ClientDto source){
        return new Client(source.identifier(),
                source.fullName(),
                source.email(),
                source.clientType(),
                source.cellphone());
    }
    public static List<ClientDto> mapFrom(List<Client> source){
        return source.parallelStream()
                .map(e ->mapFrom(e))
                .toList();
    }
}

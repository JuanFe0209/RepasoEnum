package repository;
import domain.enums.ClientType;
import domain.mapping.dtos.ClientDto;
import domain.mapping.mappers.ClientMapper;
import domain.models.Client;

import java.util.ArrayList;
import java.util.List;

public class ClientRepositoryImpl implements ClientRepository{

    List<Client> clients;
    public ClientRepositoryImpl(){
        clients = new ArrayList<Client>();
    }
    @Override
    public ClientDto createClient(ClientDto client) {
        clients.add(ClientMapper.mapFrom(client));
        return client;
    }

    @Override
    public ClientDto updateClient(ClientDto client) {
        Client clientSaved = findById(client.identifier());
        clientSaved.setContact(client.cellphone());
        clientSaved.setEmail(client.email());
        clientSaved.setFullName(client.fullName());
        updateClientList(clientSaved);
        return ClientMapper.mapFrom(clientSaved);
    }
    private void updateClientList(Client client) {
        clients.remove(client);
        clients.add(client);
    }
    @Override
    public String removeClient(String clientId) {
        clients.remove(findById(clientId));
        return "user removed"+ clients.toString();
    }

    @Override
    public List<ClientDto> listAllClient() {
        return ClientMapper.mapFrom(clients);
    }

    @Override
    public List<ClientDto> listAllByType(ClientType type) {
        return clients.stream()
                .filter(e ->e.getType(). equals(type))
                .map(e->ClientMapper.mapFrom(e))
                .toList();
    }

    @Override
    public ClientDto findClientById(String clientId) {
        return ClientMapper.mapFrom(findById(clientId));
    }

    private Client findById(String identifier){
        for(Client client: clients){
            if (client.getIdentifeir().equalsIgnoreCase(identifier)){
                return client;
            }
        }
        throw new RuntimeException("Client not found");
    }
}
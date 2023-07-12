import domain.enums.ClientType;
import domain.mapping.dtos.ClientDto;
import repository.ClientRepository;
import repository.ClientRepositoryImpl;
import services.ClientService;
import services.impl.ClientServiceImpl;

public class Main {
    public static void main(String[] args) {
        ClientRepository repository = new ClientRepositoryImpl();
        ClientService service = new ClientServiceImpl(repository);
        createClients(service);

        System.out.println("Clients: "+service.listAllClient());

        service.updateClient(new ClientDto("1", "Felipe", "jrojas2291@cue.edu.co", ClientType.TEAR1, "12345"));

        System.out.println("Clients upadted"+ service.listAllClient());

        System.out.println("Clients filtered: ");

        service.listAllByType(ClientType.TEAR2).forEach(System.out::println);

        service.removeClient("3");

        System.out.println("Clients updated (2):"+ service.listAllClient());

        System.out.println("Message");

        service.printMessage("2");

    }
    private static void createClients(ClientService service){
        service.createClient(new ClientDto("1", "Felipe", "jrojas2291@cue.edu.co", ClientType.TEAR1,"123"));
        service.createClient(new ClientDto("2", "Andres", "Andres21cue.edu.co", ClientType.TEAR2,"456"));
        service.createClient(new ClientDto("3", "Mateo", "Mateo22@cue.edu.co", ClientType.TEAR3,"789"));
    }
}
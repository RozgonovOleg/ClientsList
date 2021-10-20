package Clients.ClientsApp.service;

import Clients.ClientsApp.exceptions.IdNotFoundException;
import Clients.ClientsApp.model.Clients;
import Clients.ClientsApp.repository.Repository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClientsService {
    private final Repository repository;

    public ClientsService(Repository repository) {
        super();
        this.repository = repository;
    }

    public List<Clients> getAllClients() {
        if (repository.findAll().isEmpty()) {
            throw new IdNotFoundException("No one client found");
        }

        return repository.findByisActive(true);
    }

    public Clients getClientById(long id) {

        return repository.findById(id).orElseThrow(() -> new IdNotFoundException("id not found"));
    }


    public Clients createClients(Clients clients) {
        return repository.save(clients);
    }

    public Clients updateClients(long id, Clients clientsRequest) {
        Clients clients = repository.findById(id).orElseThrow(() -> new IdNotFoundException("id not found"));

        clients.setLastName(clientsRequest.getLastName());
        clients.setFirstName(clientsRequest.getFirstName());
        clients.setPatronymic(clientsRequest.getPatronymic());
        clients.setYear(clientsRequest.getYear());
        clients.setGender(clientsRequest.getGender());
        clients.setPhone(clientsRequest.getPhone());
        clients.setEmail(clientsRequest.getEmail());

        return repository.save(clients);
    }

    public void deleteClients(long id) {
        Clients clients = repository.findById(id).orElseThrow(() -> new IdNotFoundException("id not found"));
        clients.setActive(false);
        repository.save(clients);

    }


}

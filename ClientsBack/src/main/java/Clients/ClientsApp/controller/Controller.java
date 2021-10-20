package Clients.ClientsApp.controller;

import Clients.ClientsApp.dto.ClientsDto;
import Clients.ClientsApp.model.Clients;
import Clients.ClientsApp.repository.Repository;
import Clients.ClientsApp.service.ClientsService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@CrossOrigin(origins="http://localhost:4200")
@RequestMapping("/api")
public class Controller {

    @Autowired
    private ModelMapper modelMapper;
    Repository repository;
    ClientsService clientsService;

    public Controller(ClientsService clientsService) {
        super();
        this.clientsService = clientsService;
    }

    @GetMapping("/clients")
    public List<ClientsDto> getAllClients() {

        return clientsService.getAllClients().stream().map(customers ->
                modelMapper.map(customers, ClientsDto.class)).collect(Collectors.toList());
    }

    @GetMapping("/clients/{id}")
    public ResponseEntity<ClientsDto> getCustomerById(@PathVariable("id") long id) {
        Clients customers = clientsService.getClientById(id);
        ClientsDto clientsResponce = modelMapper.map(customers, ClientsDto.class);
        return ResponseEntity.ok().body(clientsResponce);
    }

    @PostMapping("/save-clients")
    public ResponseEntity<ClientsDto> createCustomers(@Valid @RequestBody ClientsDto clientsDto) {
        Clients newClients = modelMapper.map(clientsDto, Clients.class);
        Clients clients = clientsService.createClients(newClients);
        ClientsDto clientsResponce = modelMapper.map(clients, ClientsDto.class);
        return new ResponseEntity<>(clientsResponce, HttpStatus.CREATED);
    }

    @PutMapping("/update-clients/{id}")
    public ResponseEntity<ClientsDto> updateClients( @PathVariable("id") long id,
                                                     @Valid @RequestBody ClientsDto clientsDto) {

        Clients updatedCustomer = modelMapper.map(clientsDto, Clients.class);
        Clients customers = clientsService.updateClients(id, updatedCustomer);
        ClientsDto customerResponce = modelMapper.map(customers, ClientsDto.class);
        return ResponseEntity.ok().body(customerResponce);

    }

    @DeleteMapping("/delete-clients/{id}")
    public ResponseEntity<ClientsDto> deleteClients(@PathVariable("id") long id) {
        clientsService.deleteClients(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}

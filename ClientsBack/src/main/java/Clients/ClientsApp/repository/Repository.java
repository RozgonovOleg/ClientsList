package Clients.ClientsApp.repository;

import Clients.ClientsApp.model.Clients;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface Repository extends JpaRepository<Clients, Long> {

    List<Clients> findByisActive(Boolean isActive);
}

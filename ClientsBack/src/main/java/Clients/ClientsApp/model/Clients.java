package Clients.ClientsApp.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "clients")
public class Clients {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "lastName", length = 20)
    private String lastName;

    @Column(name = "firstName", length = 20)
    private String firstName;

    @Column(name = "patronymic", length = 20)
    private String patronymic;

    @Column(name = "year", length = 4)
    private String year;

    @Column(name = "gender", length = 6)
    private String gender;

    @Column(name = "phone", length = 15)
    private String phone;

    @Column(name = "email", unique = true)
    private String email;

    @Column(name = "isActive")
    private boolean isActive = true;



}

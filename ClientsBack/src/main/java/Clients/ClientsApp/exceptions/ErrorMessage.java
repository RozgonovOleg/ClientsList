package Clients.ClientsApp.exceptions;

import lombok.*;

import java.util.Date;

@Data
@AllArgsConstructor

public class ErrorMessage {

    private int status;

    private Date timestamp;

    private String message;

    private String description;


}
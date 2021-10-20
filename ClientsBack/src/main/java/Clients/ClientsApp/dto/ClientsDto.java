package Clients.ClientsApp.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Data
@RequiredArgsConstructor
@AllArgsConstructor

public class ClientsDto {

    private long id;

    @NotBlank
    @Length(min = 2, max = 20)
    @Pattern(regexp = "^[а-яА-ЯёЁ\\s]+$")
    private String lastName;

    @NotBlank
    @Length(min = 2, max = 20)
    @Pattern(regexp = "^[а-яА-ЯёЁ\\s]+$")
    private String firstName;

    @NotBlank
    @Length(min = 2, max = 20)
    @Pattern(regexp = "^[а-яА-ЯёЁ\\s]+$")
    private String patronymic;

    @NotBlank
    @Size(min=4, max = 4)
    @Pattern(regexp = "\\d+")
    private String year;

    @NotBlank
    @Pattern(regexp = "м|ж")
    private String gender;

    @NotBlank
    @Length(max = 15)
    @Pattern(regexp = "^$|^\\+(?:[0-9] ?){6,14}[0-9]$")
    private String phone;

    @NotBlank
    @Email
    private String email;

}

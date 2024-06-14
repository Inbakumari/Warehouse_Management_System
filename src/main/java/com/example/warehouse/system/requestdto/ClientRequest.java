package com.example.warehouse.system.requestdto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ClientRequest {

    @NotNull(message = "username cannot be null")
    @NotBlank(message = "username cannot be blank")
    @Pattern(regexp = "^[a-zA-Z]+$", message = "Name should only contain alphabetic characters")
    private String businessName;

    @Pattern(regexp = "^[a-zA-Z0-9._%+-]+@gmail\\.com$", message = "Email should end with @gmail.com")
    @NotNull(message = "email cannot be null")
    @NotBlank(message = "email cannot be blank")
    private String email;

    @NotNull(message = "contact number cannot be null")
    @NotBlank(message = "contact number cannot be blank")
    @Pattern(regexp = "^[0-9]{10}$", message = "Contact number must be a 10-digit numeric value")
    private String contactNumber;

    private String apiKey;
}

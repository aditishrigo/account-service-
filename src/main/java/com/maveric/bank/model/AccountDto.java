package com.maveric.bank.model;

import lombok.Data;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
public class AccountDto {
    @NotNull(message = "Account type cannot be null")
    @Size(min = 3, max = 10)
    private String AccountType;
    private String CustomerId;

}

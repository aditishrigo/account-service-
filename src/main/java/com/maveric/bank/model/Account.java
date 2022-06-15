package com.maveric.bank.model;
import lombok.*;

import javax.persistence.*;
@Getter
@Setter
@ToString
@RequiredArgsConstructor


@Table(name = "account")

public class Account {
    @Column(name = "Account_Type")
    private String AccountType;
    @Column(name = "CustomerId")
    private int CustomerId;

    public Account(String AccountType, int customerId) {
        this.AccountType = AccountType;
        this.CustomerId = customerId;
    }
}

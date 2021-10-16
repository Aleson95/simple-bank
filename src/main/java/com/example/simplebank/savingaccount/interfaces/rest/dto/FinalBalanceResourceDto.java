package com.example.simplebank.savingaccount.interfaces.rest.dto;

import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;

@Data
@Builder
public class FinalBalanceResourceDto {

    private SavingAccountResourceDto savingAccount;

    private BigDecimal finalBalance;

}

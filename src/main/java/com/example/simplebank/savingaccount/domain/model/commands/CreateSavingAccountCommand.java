package com.example.simplebank.savingaccount.domain.model.commands;

import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;

@Data
@Builder
public class CreateSavingAccountCommand {

    private Integer savingTenor;

    private BigDecimal firstDepositAmount;

    private BigDecimal monthlyDepositAmount;

    private String purposeOfSaving;

}

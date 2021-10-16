package com.example.simplebank.savingaccount.interfaces.rest.dto;

import lombok.Builder;
import lombok.Data;

import javax.validation.constraints.Digits;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

@Data
@Builder
public class SavingAccountResourceDto {

    @NotNull
    @Min(value=1)
    @Digits(fraction = 0, integer = 10)
    private Integer savingTenor;

    @NotNull
    @Min(value=0)
    @Digits(fraction = 0, integer = 15)
    private BigDecimal firstDepositAmount;

    @NotNull
    @Min(value=0)
    @Digits(fraction = 0, integer = 15)
    private BigDecimal monthlyDepositAmount;

    @NotNull
    @NotEmpty
    private String purposeOfSaving;

}

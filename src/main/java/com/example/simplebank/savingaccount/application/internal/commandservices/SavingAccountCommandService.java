package com.example.simplebank.savingaccount.application.internal.commandservices;

import com.example.simplebank.savingaccount.domain.model.aggregates.SavingAccount;
import com.example.simplebank.savingaccount.domain.model.commands.CreateSavingAccountCommand;
import com.example.simplebank.savingaccount.infrastructure.repositories.SavingAccountRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class SavingAccountCommandService {

    private final SavingAccountRepository repository;

    public SavingAccount createSavingAccount(CreateSavingAccountCommand command){
        SavingAccount savingAccount = toDomainModelFromCommand(command);
        return repository.save(savingAccount);
    }

    public SavingAccount toDomainModelFromCommand(CreateSavingAccountCommand command){
        return SavingAccount.builder()
                .savingTenor(command.getSavingTenor())
                .firstDepositAmount(command.getFirstDepositAmount())
                .monthlyDepositAmount(command.getMonthlyDepositAmount())
                .purposeOfSaving(command.getPurposeOfSaving())
                .build();
    }

}

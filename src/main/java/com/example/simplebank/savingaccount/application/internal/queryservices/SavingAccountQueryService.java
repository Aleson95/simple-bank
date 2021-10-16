package com.example.simplebank.savingaccount.application.internal.queryservices;

import com.example.simplebank.savingaccount.domain.model.aggregates.SavingAccount;
import com.example.simplebank.savingaccount.infrastructure.repositories.SavingAccountRepository;
import com.example.simplebank.shareddomain.commons.exceptions.AppException;
import lombok.AllArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

import static com.example.simplebank.shareddomain.commons.constants.AppConstant.*;

@Service
@AllArgsConstructor
public class SavingAccountQueryService {

    private final SavingAccountRepository repository;

    public List<SavingAccount> getAllSavingAccounts(){
        return repository.findAll();
    }

    @SneakyThrows
    public SavingAccount getSavingAccountById(String id){
        Optional<SavingAccount> optionalSavingAccount = repository.findById(Long.valueOf(id));
        if (optionalSavingAccount.isEmpty()){
            throw new AppException("Saving Account Id", "Data Saving Account tidak ditemukan");
        }
        return optionalSavingAccount.get();
    }

    public BigDecimal calculateFinalBalance(int savingTenor, BigDecimal firstDeposit, BigDecimal monthlyDeposit){
        BigDecimal interest = BigDecimal.valueOf(INTEREST_PERCENTAGE);
        BigDecimal duration = BigDecimal.valueOf(savingTenor);
        BigDecimal totalDuration = BigDecimal.valueOf(savingTenor / MONTHLY);
        BigDecimal totalMonthly = monthlyDeposit.multiply(duration);
        BigDecimal grandTotal = totalMonthly.add(firstDeposit);
        BigDecimal totalInterest = interest.multiply(totalDuration).multiply(grandTotal);
        return totalInterest.add(grandTotal);
    }

}

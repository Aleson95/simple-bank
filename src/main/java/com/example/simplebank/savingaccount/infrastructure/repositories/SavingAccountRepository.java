package com.example.simplebank.savingaccount.infrastructure.repositories;

import com.example.simplebank.savingaccount.domain.model.aggregates.SavingAccount;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface SavingAccountRepository extends JpaRepository<SavingAccount, Long>, JpaSpecificationExecutor<SavingAccount> {
}

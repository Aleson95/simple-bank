package com.example.simplebank.savingaccount.domain.model.aggregates;

import com.example.simplebank.configs.audit.JpaAuditListener;
import com.example.simplebank.shareddomain.models.BaseAggregate;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "saving_account")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@EntityListeners({JpaAuditListener.class})
public class SavingAccount extends BaseAggregate {

    @Id
    @SequenceGenerator(name="saving_account_id_seq",
            sequenceName="saving_account_id_seq",
            allocationSize=1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE,
            generator="saving_account_id_seq")
    @Column(name = "id")
    private Long id;

    @Column(name = "saving_tenor")
    private Integer savingTenor;

    @Column(name = "first_deposit_amount")
    private BigDecimal firstDepositAmount;

    @Column(name = "monthly_deposit_amount")
    private BigDecimal monthlyDepositAmount;

    @Column(name = "purpose_of_saving", length = 255)
    private String purposeOfSaving;

    @Version
    private Long version;
}

package com.example.simplebank.savingaccount.interfaces.rest;

import com.example.simplebank.configs.audit.JpaAuditListener;
import com.example.simplebank.savingaccount.application.internal.queryservices.SavingAccountQueryService;
import com.example.simplebank.savingaccount.domain.model.aggregates.SavingAccount;
import com.example.simplebank.savingaccount.domain.model.commands.CreateSavingAccountCommand;
import com.example.simplebank.savingaccount.application.internal.commandservices.SavingAccountCommandService;
import com.example.simplebank.savingaccount.interfaces.rest.dto.SavingAccountResourceDto;
import com.example.simplebank.shareddomain.commons.messages.AppResponse;
import com.example.simplebank.shareddomain.commons.utils.AppUtils;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityListeners;
import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/savingaccount")
@AllArgsConstructor
public class SavingAccountController {

    private final SavingAccountCommandService commandService;
    private final SavingAccountQueryService queryService;

    @PostMapping
    public ResponseEntity<?> tryCreateSavingAccount(@Valid @RequestBody SavingAccountResourceDto resourceDto,
                                                    BindingResult bindingResult) {
        //validation guard
        if (bindingResult.hasErrors()){
            return ResponseEntity.badRequest()
                    .body(mapValidationErrors(bindingResult, "Belum berhasil membuat Saving Account, Harap periksa dan coba kembali!"));
        }

        SavingAccount savingAccount = commandService.createSavingAccount(toCommandFromDto(resourceDto));
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(AppUtils.successResponse("Berhasil membuat Saving Account baru!", savingAccount));
    }

    @GetMapping
    public ResponseEntity<?> tryGetAllSavingAccounts(){
        List<SavingAccount> savingAccounts = queryService.getAllSavingAccounts();
        return ResponseEntity.ok(AppUtils.successResponse("Berhasil mengambil data Saving Account", savingAccounts));
    }

    @GetMapping("/{savingAccountId}")
    public ResponseEntity<?> tryGetSavingAccountDetail(@PathVariable String savingAccountId){
        SavingAccount savingAccount = queryService.getSavingAccountById(savingAccountId);
        return ResponseEntity.ok(AppUtils.successResponse("Berhasil mengambil data Saving Account", savingAccount));
    }

    public CreateSavingAccountCommand toCommandFromDto(SavingAccountResourceDto resourceDto){
        return CreateSavingAccountCommand.builder()
                .savingTenor(resourceDto.getSavingTenor())
                .firstDepositAmount(resourceDto.getFirstDepositAmount())
                .monthlyDepositAmount(resourceDto.getMonthlyDepositAmount())
                .purposeOfSaving(resourceDto.getPurposeOfSaving())
                .build();
    }

    public AppResponse mapValidationErrors(BindingResult bindingResult, String message){
        String field = ((FieldError) bindingResult.getAllErrors().get(0)).getField();
        String errorMessage = bindingResult.getAllErrors().get(0).getDefaultMessage();
        return AppUtils.errorResponse(message, field, errorMessage);
    }

}

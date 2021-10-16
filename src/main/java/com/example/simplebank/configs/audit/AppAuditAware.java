package com.example.simplebank.configs.audit;

import com.example.simplebank.shareddomain.commons.constants.AppConstant;
import org.springframework.data.domain.AuditorAware;

import java.util.Optional;

public class AppAuditAware implements AuditorAware<String> {
    @Override
    public Optional<String> getCurrentAuditor() {
        return Optional.ofNullable(AppConstant.TEST_USER);
    }
}

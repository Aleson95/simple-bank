package com.example.simplebank.configs.audit;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.AuditorAware;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@Configuration
@EnableJpaAuditing(auditorAwareRef = "appAuditProvider")
public class JpaAuditConfig {

    @Bean
    public AuditorAware<String> appAuditProvider() {
        return new AppAuditAware();
    }

}

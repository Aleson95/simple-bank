package com.example.simplebank.configs.audit;

import com.example.simplebank.shareddomain.commons.constants.AppConstant;
import com.example.simplebank.shareddomain.models.BaseAggregate;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.AuditorAware;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import java.time.LocalDateTime;
import java.util.Optional;

@Slf4j
@Component
@AllArgsConstructor
public class JpaAuditListener {

    private Optional<AuditorAware<String>> auditorAware;

    public String getAuditor() {
        return this.auditorAware.map(AuditorAware::getCurrentAuditor).map(Optional::get).orElse(AppConstant.TEST_USER);
    }

    @PrePersist
    public void setCreatedOn(Object object) {
        Assert.isTrue(object instanceof BaseAggregate, "Object not instance of BaseAggregate");
        BaseAggregate base = (BaseAggregate) object;
        base.setCreatedBy(this.getAuditor());
        base.setCreatedDt(LocalDateTime.now());
    }

    @PreUpdate
    public void setUpdatedOn(Object object) {
        Assert.isTrue(object instanceof BaseAggregate, "Object not instance of BaseAggregate");
        BaseAggregate base = (BaseAggregate) object;
        base.setChangedBy(this.getAuditor());
        base.setChangedDt(LocalDateTime.now());
    }
}

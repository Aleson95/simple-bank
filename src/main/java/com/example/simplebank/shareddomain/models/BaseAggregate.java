package com.example.simplebank.shareddomain.models;

import lombok.Data;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import java.time.LocalDateTime;

@Data
@MappedSuperclass
public class BaseAggregate {

    @CreatedBy
    @Column(name = "created_by", length = 50)
    private String createdBy;

    @CreatedDate
    @Column(name = "created_dt")
    private LocalDateTime createdDt;

    @LastModifiedBy
    @Column(name = "changed_by", length = 50)
    private String changedBy;

    @LastModifiedDate
    @Column(name = "changed_dt")
    private LocalDateTime changedDt;

}

package com.exam.sabamchedlishvili.entities;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.util.Date;

@Getter
@Setter
@RequiredArgsConstructor
@EqualsAndHashCode
@ToString
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public abstract class AppEntity {
    @CreatedDate
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="CREATED_DATE", updatable = false)
    protected Date createdDate;

    @LastModifiedDate
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="UPDATED_DATE")
    protected Date lastModifiedDate;

    @Enumerated(EnumType.STRING)
    @Column(name = "RECORD_STATE", updatable = true)
    protected RecordState recordState;
}

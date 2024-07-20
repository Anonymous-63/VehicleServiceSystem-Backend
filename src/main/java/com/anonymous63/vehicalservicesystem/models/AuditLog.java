package com.anonymous63.vehicalservicesystem.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Entity
public class AuditLog {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String action;
    private Long entityId;
    private String entityName;
    private String methodName;
    private String userName;
    private String userId;
    private String details;
    private String message;
    private LocalDateTime dateTime = LocalDateTime.now();

}

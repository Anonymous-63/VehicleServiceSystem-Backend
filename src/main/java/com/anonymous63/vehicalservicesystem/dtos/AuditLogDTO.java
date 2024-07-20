package com.anonymous63.vehicalservicesystem.dtos;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Data;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Builder
@Data
public class AuditLogDTO {

    private Long id;
    private String action;
    private Long entityId;
    private String entityName;
    private String methodName;
    private String userName;
    private String userId;
    private String details;
    private String message;
}

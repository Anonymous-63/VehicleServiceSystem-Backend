package com.anonymous63.vehicalservicesystem.services;

import com.anonymous63.vehicalservicesystem.dtos.AuditLogDTO;


public interface AuditLogService {

    void auditLog(AuditLogDTO auditLogDTO);
}

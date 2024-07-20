package com.anonymous63.vehicalservicesystem.services.impl;

import com.anonymous63.vehicalservicesystem.dtos.AuditLogDTO;
import com.anonymous63.vehicalservicesystem.models.AuditLog;
import com.anonymous63.vehicalservicesystem.repositories.AuditLogRepo;
import com.anonymous63.vehicalservicesystem.services.AuditLogService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuditLogServiceImpl implements AuditLogService {

    private final AuditLogRepo auditLogRepo;
    private final ModelMapper modelMapper;

    @Autowired
    public AuditLogServiceImpl(AuditLogRepo auditLogRepo, ModelMapper modelMapper) {
        this.auditLogRepo = auditLogRepo;
        this.modelMapper = modelMapper;
    }


    @Override
    public void auditLog(AuditLogDTO auditLogDTO) {
        AuditLog auditLog = this.modelMapper.map(auditLogDTO, AuditLog.class);
        this.auditLogRepo.save(auditLog);

    }
}

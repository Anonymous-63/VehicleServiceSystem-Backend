package com.anonymous63.vehicalservicesystem.payloads.aops;

import com.anonymous63.vehicalservicesystem.dtos.AuditLogDTO;
import com.anonymous63.vehicalservicesystem.services.AuditLogService;
import com.anonymous63.vehicalservicesystem.utils.Constants;
import com.anonymous63.vehicalservicesystem.utils.CustomeDtoNameResolver;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@Aspect
public class LoggingAspect {

    private  final AuditLogService auditLogService;

    @Autowired
    public LoggingAspect(AuditLogService auditLogService) {
        this.auditLogService = auditLogService;
    }

    @After("execution(* com.anonymous63.vehicalservicesystem.services.CRUDService.save(..))")
    public void crudServiceSaveLog(JoinPoint joinPoint) {
        String methodName = joinPoint.getSignature().getName();
        String className = joinPoint.getTarget().getClass().getSimpleName();
        Object[] args = joinPoint.getArgs();
        String entityName = (args != null && args.length > 0)
                ? CustomeDtoNameResolver.resolve(args[0].getClass())
                : className;

        AuditLogDTO auditLog = AuditLogDTO.builder()
                .action(Constants.Operation.SAVE.getOperationName())
                .entityName(entityName)
                .methodName(methodName)
                .message(Constants.Operation.SAVE.getOperationName() + " " + entityName)
                .build();

        this.auditLogService.auditLog(auditLog);
    }


}

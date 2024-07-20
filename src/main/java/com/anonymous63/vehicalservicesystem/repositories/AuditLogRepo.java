package com.anonymous63.vehicalservicesystem.repositories;

import com.anonymous63.vehicalservicesystem.models.AuditLog;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuditLogRepo extends JpaRepository<AuditLog, Long> {
}

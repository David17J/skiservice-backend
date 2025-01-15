package com.ipso.skiservice.backend.repository;

import com.ipso.skiservice.backend.entity.ActionLog;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ActionLogRepository extends JpaRepository<ActionLog, Long> {
}

package com.example.findapro.core.finishedTask;

import com.example.findapro.domain.FinishedTask;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FinishedTaskRepository extends JpaRepository<FinishedTask, Long> {
}

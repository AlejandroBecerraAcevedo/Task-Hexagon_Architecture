package com.hexagonal.spring_practice_hexagonal.domain.ports.out;

import com.hexagonal.spring_practice_hexagonal.domain.models.AdditionalTaskInfo;

public interface ExternalServicePort {
    AdditionalTaskInfo getAdditionalTaskInfo(Long taskId);
}

package com.hexagonal.spring_practice_hexagonal.domain.ports.in;

import com.hexagonal.spring_practice_hexagonal.domain.models.AdditionalTaskInfo;

public interface GetAdditionalTaskInfoUseCase {
    AdditionalTaskInfo getAdditionalTaskInfo(Long id);
}

package com.hexagonal.spring_practice_hexagonal.application.usecases;


import com.hexagonal.spring_practice_hexagonal.domain.ports.in.GetAdditionalTaskInfoUseCase;
import com.hexagonal.spring_practice_hexagonal.domain.models.AdditionalTaskInfo;
import com.hexagonal.spring_practice_hexagonal.domain.ports.out.ExternalServicePort;


import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class GetAdditionalTaskInfoUseCaseImplementation implements GetAdditionalTaskInfoUseCase {

    private final ExternalServicePort externalServicePort;

    @Override
    public AdditionalTaskInfo getAdditionalTaskInfo(Long id) {
        return externalServicePort.getAdditionalTaskInfo(id);
    }
    
}

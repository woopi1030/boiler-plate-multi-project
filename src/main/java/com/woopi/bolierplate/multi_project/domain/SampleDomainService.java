package com.woopi.bolierplate.multi_project.domain;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.woopi.bolierplate.multi_project.core.entity.Sample;
import com.woopi.bolierplate.multi_project.core.exception.NotFoundException;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class SampleDomainService {
    
    /* REPOSITORY */ 
    private final SampleRepository sampleRepository;

    /* GET METHODS */

    /**
     * Sample 전체 조회
     * @return 
     */
    public List<Sample> getSamples() {
        // TODO: 요청 파라미터가 없는 경우에  Not Found Exception을 어떻게 표현할지 고민해야함
        // TODO: Sample.class가 아니고, List<Sample>.class인데, 그렇게 들어가진 않는다....어떻게 할까
        return Optional.of(sampleRepository.findAll()).orElseThrow(() -> new NotFoundException(Sample.class, null));
    }

    /**
     * id로 Sample 조회
     * @param id
     * @return
     */
    public Sample getSample (Long id) {
        return sampleRepository.findById(id).orElseThrow(() -> new NotFoundException(Sample.class, id));
    }

    /* CREATE METHODS */

    /* UPDATE METHODS */

    /* DELETE METHODS */

}

package com.woopi.bolierplate.multi_project.domain;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.woopi.bolierplate.multi_project.core.entity.SampleEntity;
import com.woopi.bolierplate.multi_project.core.response.BaseResponse;

import lombok.RequiredArgsConstructor;

//TODO: swagger annotaion 추가

@RequiredArgsConstructor
@RequestMapping("/v1/sample")
@RestController
public class SampleController {

    /* SERVICES */ 
    private final SampleService sampleService;
    
    /* GET ENDPOINT */

    /**
     * Sample 전체 조회
     */
    @GetMapping
    public BaseResponse<List<SampleEntity>> getSamples() {
        return BaseResponse.successWithData(sampleService.getSamples());
    }

        /**
     * Sample 전체 조회
     */
    @GetMapping ("/{id}")
    public BaseResponse<SampleEntity> getSample(@PathVariable Long id) {
        return BaseResponse.successWithData(sampleService.getSample(id));
    }

    /* POST ENDPOINT */

    /* PATCH ENDPOINT */

    /* DELETE ENDPOINT */

}

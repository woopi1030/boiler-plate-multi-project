package com.woopi.bolierplate.multi_project.domain;

import org.springframework.data.jpa.repository.JpaRepository;

import com.woopi.bolierplate.multi_project.core.entity.Sample;

public interface SampleRepository extends JpaRepository<Sample, Long> {

}

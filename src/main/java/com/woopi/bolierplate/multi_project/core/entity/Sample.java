package com.woopi.bolierplate.multi_project.core.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_sample")
public class Sample {

    @Id //기본 키 지정
    @GeneratedValue(strategy = GenerationType.IDENTITY) //값 자동 생성 (IDENTIFY : 기본 키 생성을 데이터베이스에 위임)
    private Long id;

    @Column(length = 255, nullable = false)     //column 지정, 길이 : 255, null을 허용하지 않음
    private String name;


    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
}

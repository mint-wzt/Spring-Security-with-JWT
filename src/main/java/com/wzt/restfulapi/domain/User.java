package com.wzt.restfulapi.domain;

import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

@Entity
@Data
@GenericGenerator(name = "jpa-uuid",strategy = "uuid")
public class User {

    @Id
    @NotNull
    @GeneratedValue(generator = "jpa-uuid")
    private String id;

    @NotNull
    private String userName;

    private Integer age;
}

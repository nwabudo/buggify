package com.neookpara.buggify.entity;

import com.neookpara.buggify.entity.enums.ERole;
import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "tbl_roles")
@Data
public class Role extends Auditable{

    @Column(unique = true)
    @Enumerated(value = EnumType.STRING)
    private ERole name;
    private String description;
}

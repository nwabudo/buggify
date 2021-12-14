package com.neookpara.buggify.entity;

import com.neookpara.buggify.entity.enums.Status;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "tbl_bugs")
@Data
@NoArgsConstructor
public class Bug extends Auditable{

    private String title;
    private String description;

    @Enumerated(value = EnumType.STRING)
    private Status status;

    @ManyToOne(cascade = CascadeType.PERSIST)
    private User developer;

    public Bug(Long id, String title, String description, Status status, User developer){
        super(id);
        this.title = title;
        this.description = description;
        this.status = status;
        this.developer = developer;
    }

}

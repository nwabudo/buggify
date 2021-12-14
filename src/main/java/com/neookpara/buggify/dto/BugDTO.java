package com.neookpara.buggify.dto;

import com.neookpara.buggify.entity.enums.Status;
import lombok.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BugDTO {

    private long id;
    private String title;
    private String description;
    private Status status;
    private String devEmail;
}

package com.coderhouse.model.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class UserResponse {

    private String code;
    private String createDate;
    private String serviceTime;
    private Boolean status;
    private String type;
    private String description;
    private Double price;

}

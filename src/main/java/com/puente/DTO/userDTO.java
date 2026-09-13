package com.puente.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class userDTO {
    private Long id;
    private String name;
    private String lastname;
    private String email;
    private String password; //encriptada
    private String area;
}

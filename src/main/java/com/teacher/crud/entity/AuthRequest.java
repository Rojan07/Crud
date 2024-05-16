package com.teacher.crud.entity;

import lombok.*;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Data
public class AuthRequest {
    private String username;
    private String password;
}

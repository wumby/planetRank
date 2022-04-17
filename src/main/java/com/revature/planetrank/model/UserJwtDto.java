package com.revature.planetrank.model;


import lombok.*;

@NoArgsConstructor @Getter @Setter @ToString @AllArgsConstructor
public class UserJwtDto {

    private int userId;
    private String username;
    private String userRole;

}

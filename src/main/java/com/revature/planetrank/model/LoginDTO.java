package com.revature.planetrank.model;


import lombok.*;

import java.util.Objects;

@NoArgsConstructor @Getter @Setter @ToString @AllArgsConstructor
public class LoginDTO {

    private String username;
    private String password;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LoginDTO loginDTO = (LoginDTO) o;
        return Objects.equals(username, loginDTO.username) && Objects.equals(password, loginDTO.password);
    }

    @Override
    public int hashCode() {
        return Objects.hash(username, password);
    }
}

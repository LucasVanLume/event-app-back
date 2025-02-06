package com.eventapp.event_api.dto.auth.login;

public record LoginRequestDTO (String email, String password) {
    /*private String email;
    private String password;

    public LoginRequestDTO(String email, String password) {
        this.email = email;
        this.password = password;
    }*/
}

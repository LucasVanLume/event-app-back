package com.eventapp.event_api.dto.auth.register;

public record RegisterRequestDTO (String name, String email, String password) {
    /*private String name;
    private String email;
    private String password;

    public RegisterRequestDTO(String name, String email, String password) {
        this.name = name;
        this.email = email;
        this.password = password;
    }*/
}

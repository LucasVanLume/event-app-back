package com.eventapp.event_api.infra.security;

import com.eventapp.event_api.domain.user.User;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

@Component
public class UserDetailsService {

    public Authentication getAuthentication() {
        return SecurityContextHolder.getContext().getAuthentication();
    }

    public User getAuthenticatedUser() {
        Object principal = getAuthentication().getPrincipal();
        if (principal instanceof User user) {
            return user;
        } else {
            throw new RuntimeException("User authentication is invalid");
        }
    }
}

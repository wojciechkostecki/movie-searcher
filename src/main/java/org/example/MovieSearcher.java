package org.example;

import org.example.model.Role;
import org.example.model.UserRole;
import org.example.repository.UserRoleRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;

@SpringBootApplication
public class MovieSearcher {

    private final UserRoleRepository userRoleRepository;

    public MovieSearcher(UserRoleRepository userRoleRepository) {
        this.userRoleRepository = userRoleRepository;
    }

    public static void main(String[] args) {
        SpringApplication.run(MovieSearcher.class, args);
    }

    @EventListener(ApplicationReadyEvent.class)
    public void afterInitSetup() {
        saveRoles();
    }

    private void saveRoles() {
        for (Role role : Role.values()) {
            if(!userRoleRepository.existsByRole(role)) {
                UserRole userRole = new UserRole();
                userRole.setRole(role);
                userRoleRepository.save(userRole);
            }
        }
    }
}
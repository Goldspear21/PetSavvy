package petsavvy.pet.controllers;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @GetMapping("/status")
    public Map<String, Object> getAuthStatus() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        Map<String, Object> response = new HashMap<>();
        
        if (auth != null && auth.isAuthenticated() && !auth.getPrincipal().equals("anonymousUser")) {
            response.put("loggedIn", true);
            boolean isAdmin = auth.getAuthorities().stream()
                    .map(GrantedAuthority::getAuthority)
                    .anyMatch(role -> role.equals("ROLE_ADMIN"));
            response.put("isAdmin", isAdmin);
        } else {
            response.put("loggedIn", false);
            response.put("isAdmin", false);
        }
        return response;
    }
}

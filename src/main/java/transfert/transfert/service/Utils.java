package transfert.transfert.service;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

@Component
public class Utils {
    public String getConnectedUser(){
        Authentication authentication= SecurityContextHolder.getContext().getAuthentication();

        return authentication.getName();
    }
}

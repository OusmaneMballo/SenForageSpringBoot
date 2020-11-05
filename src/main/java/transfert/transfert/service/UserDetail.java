package transfert.transfert.service;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import transfert.transfert.DAO.UtilisateurRepository;

@Service
public class UserDetail implements UserDetailsService {
    private UtilisateurRepository utilisateurRepos;
    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        return utilisateurRepos.findByUsername(s);
    }
}

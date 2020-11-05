package transfert.transfert.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.DefaultRedirectStrategy;
import org.springframework.security.web.RedirectStrategy;
import org.springframework.security.web.WebAttributes;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import transfert.transfert.DAO.UtilisateurRepository;
import transfert.transfert.Model.Utilisateur;
import transfert.transfert.service.UserDetail;
import transfert.transfert.service.Utils;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Collection;

public class MySimpleUrlAuthenticateSuccessHandler implements AuthenticationSuccessHandler {
    //protected Log logger=LoggerFactory.getLog(this.getClass());
    private RedirectStrategy redirectStrategy=new DefaultRedirectStrategy();
    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, FilterChain chain, Authentication authentication) throws IOException, ServletException {

    }

    @Override
    public void onAuthenticationSuccess(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Authentication authentication) throws IOException, ServletException {

    }

    protected void handle(HttpServletRequest request, HttpServletResponse response, Authentication authentication)
    throws Exception{
        String targetUrl=determineTargetUrl(authentication);
        if(response.isCommitted()){
            //logger.debug("Response has already been commited. Unable to redirect "+targetUrl);
            return;
        }
        redirectStrategy.sendRedirect(request, response, targetUrl);
    }

    @Autowired
    private UserDetail userDetail;
    @Autowired
    private UtilisateurRepository utilisateurRepos;
    @Autowired
    private Utils utils;
    protected String determineTargetUrl(Authentication authentication){

        Boolean isAdmin=false;
        Boolean isCaissier=false;

        Collection<? extends GrantedAuthority> authorities=authentication.getAuthorities();
        String role="";
        for (GrantedAuthority grantedAuthority: authorities){
            if (grantedAuthority.getAuthority().equals("ROLE_ADMIN")){
                isAdmin=true;
            }

            if (grantedAuthority.getAuthority().equals("ROLE_CAISSIER")){
                    isCaissier=true;
            }
        }
       /* final UserDetails userDetailsService=userDetail.loadUserByUsername(utils.getConnectedUser());
        Utilisateur u= (Utilisateur) authentication.getPrincipal();*/

        if(isAdmin){
            return"ADMIN";
        }
        if(isCaissier){
            return"CAISSIER";
        }
        else{
            throw new IllegalStateException();
        }
    }

    protected void clearAuthenticationAttributes(HttpServletRequest request, HttpServletResponse response){
        HttpSession session=request.getSession(false);
        if (session==null){
            return;
        }
        session.removeAttribute(WebAttributes.AUTHENTICATION_EXCEPTION);
    }
}

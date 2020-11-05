package transfert.transfert.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class ConfigSecurity extends WebSecurityConfigurerAdapter {

    @Qualifier("userDetail")
    @Autowired
    private UserDetailsService userDetailsService;
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;


    @Autowired
    protected void globalConfig(AuthenticationManagerBuilder auth) throws Exception{
        /*auth.jdbcAuthentication();*/
        auth.userDetailsService(userDetailsService).passwordEncoder(bCryptPasswordEncoder);
    }

    protected void confgure(HttpSecurity http) throws Exception{
       /* http.authorizeRequests()
                .anyRequest()
                    .authenticated()
                        .and()
                            .formLogin()
                                .loginPage("/user").permitAll();*/
        http.authorizeRequests().antMatchers("/","/login").permitAll()
                .anyRequest().authenticated().and().formLogin().loginPage("/login").failureForwardUrl("/login?error")
                .successHandler(authenticationSuccessHandler()).and().exceptionHandling();
    }

    public void configure(WebSecurity web) throws Exception{
        web.ignoring()
                .antMatchers("/resources/**","static/**","/css/**","/img/**","/js/**","/login/**","/template/**");
    }

    @Bean
    public AuthenticationSuccessHandler authenticationSuccessHandler(){

        return new MySimpleUrlAuthenticateSuccessHandler();
    }
}

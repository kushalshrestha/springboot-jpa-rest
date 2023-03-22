package id_authentication.config;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    public void configAuthentication(AuthenticationManagerBuilder auth) throws Exception {
        PasswordEncoder encoder = new BCryptPasswordEncoder();

        auth.inMemoryAuthentication()
                .passwordEncoder(encoder)
                .withUser("checker")
                .password(encoder.encode("admin"))
                .roles("Checker")
                .and()
                .withUser("member")
                .password(encoder.encode(("user")))
                .roles("Member");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        /*
        Stateless session enables authentication for every request.
        */
        http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
        http
                .csrf().disable()
                .authorizeRequests()
                .antMatchers(HttpMethod.GET, "/api/v1/plans/{id}").hasAnyRole("Member", "Checker")// Any Member can retrieve the list of plans he/she has
                .antMatchers(HttpMethod.GET,"/api/v1/memberships/{id}").hasAnyRole("Member", "Checker")// A Member And Checker Can retrieve the List of all membership
                .antMatchers("/**").hasRole("Checker")// A Checker has the Authority to access each any every endpoint
                .anyRequest()
                .authenticated()
                .and()
                .httpBasic();

    }

}


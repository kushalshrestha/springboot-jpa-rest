package id_authentication.config;


import id_authentication.domain.JwtFilter;
import lombok.RequiredArgsConstructor;
import org.apache.catalina.filters.CorsFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.reactive.UrlBasedCorsConfigurationSource;

import javax.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class WebSecurityConfig {


    @Autowired

    private UserDetailsService userService;

//    @Autowired
//    private final JwtTokenProvider jwtTokenProvider;

//    @Autowired
//
//    private final UserDetailsService userRepo;

//
//    private final JwtTokenFilter jwtTokenFilter;
//
//    public WebSecurityConfig(JwtTokenProvider jwtTokenProvider, UserDetailsService userRepo, JwtTokenFilter jwtTokenFilter) {
//        this.jwtTokenProvider = jwtTokenProvider;
//        this.userRepo = userRepo;
//        this.jwtTokenFilter = jwtTokenFilter;
//    }

    private final UserDetailsService userDetailsService;

    private final JwtFilter jwtFilter;

//    @Autowired
//    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//
//        auth.userDetailsService(userService);
//
//    }
//
//    @Bean
//    public PasswordEncoder passwordEncoder() {
//        return NoOpPasswordEncoder.getInstance();
//    }
//
//    @Override
//    @Bean
//    public AuthenticationManager authenticationManager() throws Exception {
//        return super.authenticationManagerBean();
//    }
//
//    @Override
//    protected void configure(HttpSecurity http) throws Exception {
//        http.csrf().disable()
//                .authorizeRequests().antMatchers("/authenticate").permitAll()
//                .antMatchers("/api/v1/plans").permitAll()
//                .anyRequest().authenticated();
//
//    }
//}

//        http
//                .authorizeRequests()
//                .antMatchers("/favicon.ico").permitAll()
//                .anyRequest().hasRole("Service")
////			.and()
////			.formLogin()
//                .and()
//                .csrf()
//                .disable()
//                .httpBasic();

// Enable CORS and disable CSRF
//        http = http.cors().and().csrf().disable();
//        //Set Session Management to StateLess
//        http = http.sessionManagement()
//                .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
//                .and();
//        // Set unauthorized requests exception handler
//
//        http = http.exceptionHandling()
//                .authenticationEntryPoint((
//                        (request, response, authException) -> {
//                            response.sendError(
//                                    HttpServletResponse.SC_UNAUTHORIZED, authException.getMessage()
//                            );
//                        })
//                ).and();
//
//        // Set permissions on endpoints
//
//        http.authorizeRequests()
//                //public endpoint
//                .antMatchers("/api/v1/plans/{id}").permitAll()
//                //private endpoint
//                .anyRequest().authenticated();

//JWT Token filter\\\

//    @Bean
    public UserDetailsService userDetailsSvc() {
        return userDetailsService;
    }

    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

        http
                .csrf().disable().cors().disable()
                .authorizeHttpRequests()
                .antMatchers("/api/v1/plans/{id}").permitAll()
                .antMatchers("/api/v1/plans/create").permitAll()
                .antMatchers("/api/v1/plans").permitAll()
                .antMatchers("/authenticate")
                .authenticated()
                .and()
                .sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS);

        http.addFilterBefore(jwtFilter, UsernamePasswordAuthenticationFilter.class);

        return http.build();
    }

//    @Bean
//    public WebSecurityCustomizer webSecurityCustomizer() {
//        return (web) -> web.ignoring().antMatchers("/images/**", "/js/**", "/webjars/**");
//    }

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration authConfig) throws Exception {
        return authConfig.getAuthenticationManager();
    }

    @Bean
    public DaoAuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();

        authProvider.setUserDetailsService(userDetailsSvc());
        authProvider.setPasswordEncoder(passwordEncoder());

        return authProvider;
    }
}
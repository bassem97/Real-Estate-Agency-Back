package com.wecode.realestateagency.security;

import com.wecode.realestateagency.Services.UserServiceDetails;
import org.hibernate.StatelessSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.SecurityBuilder;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.WebSecurityConfigurer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    @Autowired
    private UserServiceDetails userServiceDetails;
    @Autowired
    private JwtAuthenticationFilter authenticationFilter;
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf()
                .disable()
                .authorizeRequests()
                .antMatchers("/api/login",
                                        "/local/list",
                                        "/local/add",
                                        "/local/upload",
                                        "/local/delete/*",
                                        "/local/localById/*",
                                        "/local/isWishedByUser/*/*",
                                        "/agency/list",
                                        "/agency/register",
                                        "/user/auth",
                                        "/user/*/*",
                                        "/user/list",
                                        "/user/users/*",
                                        "/user/addLocalToWishlist/*/*",
                                        "/user/removeLocalFromWishlist/*/*",

                                        "/agency/agencyByEmail/*",
                                        "/agency/*/*",
                                        "/agency/agencyByUsername/*",
                                        "/agency/agencyByTaxRegistration/*",
                                        "/client/clientByUsername/*",
                                        "/client/clientByEmail/*",
                                        "/client/*/*",
                                        "/client/register")
                .permitAll()
                .anyRequest()
                .authenticated()
        .and().sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
        http.addFilterBefore(authenticationFilter, UsernamePasswordAuthenticationFilter.class);
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userServiceDetails);
    }
    @Bean
    public AuthenticationManager customAuthenticationManager() throws Exception {
        return authenticationManager();
    }
}

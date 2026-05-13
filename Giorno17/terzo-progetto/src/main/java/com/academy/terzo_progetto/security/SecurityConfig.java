package com.academy.terzo_progetto.security;



import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;



@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
            .csrf(csrf -> csrf.disable()) 
           .authorizeHttpRequests(auth -> auth
                .requestMatchers(HttpMethod.GET, "/api/studenti").permitAll()
                .requestMatchers(HttpMethod.GET, "/api/corsi/**").permitAll()
                .requestMatchers(HttpMethod.GET, "/api/corsi").permitAll()
                .requestMatchers(HttpMethod.GET, "/api/corsi/conta").permitAll()
                .requestMatchers(HttpMethod.GET, "/api/studenti/**").permitAll() 
                .requestMatchers(HttpMethod.POST, "/api/auth/registrazione").permitAll()
                .requestMatchers(HttpMethod.POST, "/api/studenti/**").permitAll()
                .requestMatchers(HttpMethod.PUT, "/api/corsi/**").permitAll()
                .requestMatchers(HttpMethod.PATCH, "/api/studenti/**").permitAll()
                .requestMatchers("/error").permitAll()
                .requestMatchers(HttpMethod.DELETE, "/api/studenti/**").permitAll()
                .requestMatchers(HttpMethod.DELETE, "/api/corsi/**").permitAll()
                .requestMatchers(HttpMethod.PUT, "/api/studenti/**").permitAll()
                .anyRequest().authenticated()
)
            .formLogin(form -> {}) // Questo abilita la pagina di login
            .httpBasic(basic -> {});

        return http.build();
    }

@Bean
public JdbcUserDetailsManager userDetailsManager(DataSource dataSource) {
    JdbcUserDetailsManager manager = new JdbcUserDetailsManager(dataSource);
    manager.setUsersByUsernameQuery(
        "select username, password, attivo from utente where username=?"
    );
    manager.setAuthoritiesByUsernameQuery(
        "select username, ruolo from ruolo where username=?"
    );
    manager.setCreateUserSql(
    "insert into utente (username, password, attivo) values (?,?,?)"
);
    manager.setCreateAuthoritySql(
    "insert into ruolo (username, ruolo) values (?,?)"
);
    return manager;
}

@Bean
public PasswordEncoder passwordEncoder() {
    return new BCryptPasswordEncoder();
}
}
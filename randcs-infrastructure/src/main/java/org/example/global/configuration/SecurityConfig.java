package org.example.global.configuration;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.example.global.filter.ExceptionFilter;
import org.example.global.filter.JwtFilter;
import org.example.global.security.jwt.JwtProvider;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.annotation.web.configurers.HeadersConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfig {
    private final JwtProvider jwtProvider;
    private final ObjectMapper objectMapper;

    @Bean
    public static BCryptPasswordEncoder passwordEncoder() { return new BCryptPasswordEncoder(); }

    @Bean
    public SecurityFilterChain securityFilterChain (HttpSecurity http) throws Exception {
        return http
                .csrf(AbstractHttpConfigurer::disable)
                .httpBasic(AbstractHttpConfigurer::disable)
                .formLogin(AbstractHttpConfigurer::disable)

                .authorizeHttpRequests((auth) -> {
                    auth.requestMatchers(HttpMethod.POST, "/auth/login").permitAll()
                        .requestMatchers(HttpMethod.POST, "/auth/signup").permitAll()
                        .requestMatchers(HttpMethod.POST, "/auth/code/email").permitAll()
                        .requestMatchers(HttpMethod.POST, "/auth/code/tel").permitAll()
                        .requestMatchers(HttpMethod.POST, "/auth/code/verification").permitAll()
                        .requestMatchers(HttpMethod.DELETE, "/auth").authenticated();

                    auth.requestMatchers(HttpMethod.GET, "/user/profile").authenticated()
                        .requestMatchers(HttpMethod.PATCH, "/user/profile").authenticated()
                        .requestMatchers(HttpMethod.PATCH, "/user/password").authenticated();

                    auth.requestMatchers(HttpMethod.POST, "/room").authenticated()
                        .requestMatchers(HttpMethod.DELETE, "/room").authenticated();

                    auth.requestMatchers(HttpMethod.GET, "/streak/answer/:roomId").authenticated()
                        .requestMatchers(HttpMethod.GET, "/streak/{roomId}").authenticated();

                    auth.requestMatchers(HttpMethod.GET, "/hard/answer/:roomId").authenticated()
                        .requestMatchers(HttpMethod.GET, "/hard/:roomId").authenticated();

                    auth.requestMatchers(HttpMethod.POST, "/textbook").authenticated()
                        .requestMatchers(HttpMethod.PATCH, "/textbook/:textbookId").authenticated()
                        .requestMatchers(HttpMethod.DELETE, "/textbook/:textbookId").authenticated()
                        .requestMatchers(HttpMethod.GET, "/textbook/problem/:textbookId").authenticated()
                        .requestMatchers(HttpMethod.GET, "/textbook/list").authenticated()
                        .requestMatchers(HttpMethod.POST, "/textbook/problem").authenticated();

                    auth.anyRequest().denyAll();
                })

                .sessionManagement((session) -> {
                    session.sessionCreationPolicy(SessionCreationPolicy.STATELESS);
                })

                .headers((header) -> {
                    header.frameOptions(HeadersConfigurer.FrameOptionsConfig::sameOrigin);
                })

                .addFilterBefore(new JwtFilter(jwtProvider), UsernamePasswordAuthenticationFilter.class)
                .addFilterBefore(new ExceptionFilter(objectMapper), JwtFilter.class)

                .build();
    }
}

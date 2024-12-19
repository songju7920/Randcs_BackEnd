package org.example.global.configuration;

import lombok.RequiredArgsConstructor;
import org.example.global.filter.JwtFilter;
import org.example.global.security.jwt.JwtProvider;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.annotation.web.configurers.HeadersConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfig {
    private final JwtProvider jwtProvider;

    @Bean
    public static BCryptPasswordEncoder passwordEncoder() { return new BCryptPasswordEncoder(); }

    @Bean
    public SecurityFilterChain securityFilterChain (HttpSecurity http) throws Exception {
        return http
                .csrf(AbstractHttpConfigurer::disable)
                .httpBasic(AbstractHttpConfigurer::disable)
                .formLogin(AbstractHttpConfigurer::disable)

                .authorizeHttpRequests((auth) -> {
                    auth.requestMatchers("/auth/login").permitAll()
                        .requestMatchers("/auth/signup").permitAll()
                        .requestMatchers("/auth/code/email").permitAll()
                        .requestMatchers("/auth/code/tel").permitAll()
                        .requestMatchers("/auth/code/verification").permitAll();

                    auth.requestMatchers("/user/:userId").authenticated()
                        .requestMatchers("/user/profile").authenticated()
                        .requestMatchers("/user/detail").authenticated()
                        .requestMatchers("/user/password").authenticated()
                        .requestMatchers("/user/verification").authenticated();

                    auth.requestMatchers("/streak").authenticated()
                        .requestMatchers("/streak/answer").authenticated()
                        .requestMatchers("/streak/end").authenticated();

                    auth.requestMatchers("/hard").authenticated()
                        .requestMatchers("/hard/answer").authenticated()
                        .requestMatchers("/hard/end").authenticated();

                    auth.requestMatchers("/textbook/new").authenticated()
                        .requestMatchers("/textbook/problem/:textbookId").authenticated()
                        .requestMatchers("/textbook").authenticated();

                    auth.anyRequest().denyAll();
                })

                .sessionManagement((session) -> {
                    session.sessionCreationPolicy(SessionCreationPolicy.STATELESS);
                })

                .headers((header) -> {
                    header.frameOptions(HeadersConfigurer.FrameOptionsConfig::sameOrigin);
                })

                .addFilterBefore(new JwtFilter(jwtProvider), UsernamePasswordAuthenticationFilter.class)

                .build();
    }
}

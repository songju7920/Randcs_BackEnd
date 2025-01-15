package org.example.global.configuration

import org.springframework.context.annotation.Bean
import org.springframework.http.HttpMethod
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
import org.springframework.security.config.http.SessionCreationPolicy
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import org.springframework.security.web.SecurityFilterChain

@EnableWebSecurity
class SecurityConfig(
    private val filterConfig: FilterConfig
) {

    @Bean
    fun securityFilterChain(http: HttpSecurity): SecurityFilterChain {
        http
            .csrf { it.disable() }
            .httpBasic { it.disable() }
            .formLogin { it.disable() }

            .authorizeHttpRequests { auth ->
                auth.requestMatchers(HttpMethod.POST, "/auth/login").permitAll()
                        .requestMatchers(HttpMethod.POST, "/auth/signup").permitAll()
                        .requestMatchers(HttpMethod.POST, "/auth/code/email").permitAll()
                        .requestMatchers(HttpMethod.POST, "/auth/code/tel").permitAll()
                        .requestMatchers(HttpMethod.POST, "/auth/code/verification").permitAll()
                        .requestMatchers(HttpMethod.DELETE, "/auth").authenticated()

                auth.requestMatchers(HttpMethod.GET, "/user/profile").authenticated()
                        .requestMatchers(HttpMethod.PATCH, "/user/profile").authenticated()
                        .requestMatchers(HttpMethod.PATCH, "/user/password").authenticated()

                auth.requestMatchers(HttpMethod.POST, "/room").authenticated()
                        .requestMatchers(HttpMethod.DELETE, "/room/:roomId").authenticated()

                auth.requestMatchers(HttpMethod.GET, "/streak/answer/:roomId").authenticated()
                        .requestMatchers(HttpMethod.GET, "/streak/:roomId").authenticated()

                auth.requestMatchers(HttpMethod.GET, "/hard/answer/:roomId").authenticated()
                        .requestMatchers(HttpMethod.GET, "/hard/:roomId").authenticated()

                auth.requestMatchers(HttpMethod.POST, "/textbook").authenticated()
                        .requestMatchers(HttpMethod.PATCH, "/textbook/:textbookId").authenticated()
                        .requestMatchers(HttpMethod.DELETE, "/textbook/:textbookId").authenticated()
                        .requestMatchers(HttpMethod.GET, "/textbook/problem/:textbookId").authenticated()
                        .requestMatchers(HttpMethod.GET, "/textbook/list").authenticated()
                        .requestMatchers(HttpMethod.POST, "/textbook/problem").authenticated()

                auth.anyRequest().denyAll()
            }

            .sessionManagement { session ->
                session.sessionCreationPolicy(SessionCreationPolicy.STATELESS)
            }

            .headers { header ->
                header.frameOptions{ it.sameOrigin() }
            }

            .apply(filterConfig)

        return http.build()
    }

    @Bean
    protected fun passwordEncoder(): BCryptPasswordEncoder = BCryptPasswordEncoder()
}

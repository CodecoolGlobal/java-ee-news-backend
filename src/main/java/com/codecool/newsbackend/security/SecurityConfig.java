package com.codecool.newsbackend.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    private final JwtTokenServices jwtTokenServices;

    public SecurityConfig(JwtTokenServices jwtTokenServices) {
        this.jwtTokenServices = jwtTokenServices;
    }


    @Bean
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .httpBasic().disable()
                .csrf().disable()
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and()
                .authorizeRequests()
                //.antMatchers("/**").permitAll() // allowed by anyone
                .antMatchers(HttpMethod.POST, "/login").permitAll()
                .antMatchers(HttpMethod.GET, "/login").permitAll()
                .antMatchers(HttpMethod.POST, "/registration").permitAll()
                .antMatchers(HttpMethod.GET, "/registration").permitAll()
                .antMatchers(HttpMethod.OPTIONS, "/registration").permitAll()
                .antMatchers(HttpMethod.OPTIONS, "/login").permitAll()
                .antMatchers(HttpMethod.GET, "/userpage").authenticated() // allowed only when signed in
                .antMatchers(HttpMethod.POST, "/userpage").authenticated() // allowed only when signed in
                //.antMatchers(HttpMethod.POST, "/savesettings/*").authenticated()
               // .antMatchers(HttpMethod.OPTIONS, "/savesettings/*").authenticated()
                .antMatchers("/savesettings/*").authenticated()
                .antMatchers(HttpMethod.GET, "/gettopicselection/*").authenticated()
                .antMatchers(HttpMethod.OPTIONS, "/gettopicselection/*").authenticated()
                .antMatchers(HttpMethod.GET, "/data").permitAll()
                .antMatchers(HttpMethod.GET, "/firstFive").permitAll()
                .antMatchers(HttpMethod.GET, "/techFour").permitAll()
                .antMatchers(HttpMethod.GET, "//generalFour").permitAll()
                .antMatchers(HttpMethod.GET, "/scienceFour").permitAll()

                .anyRequest().denyAll() // anything else is denied
                .and()
                .addFilterBefore(new JwtTokenFilter(jwtTokenServices), UsernamePasswordAuthenticationFilter.class);
    }
}
package com.luv2code.springboot.cruddemo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import javax.sql.DataSource;

@Configuration
public class SpringSecurityConfig {


    /*
    @Bean
    public InMemoryUserDetailsManager manager(){

        UserDetails john=User.builder().
                username("john")
                .password("{noop}test123")
                .roles("EMPLOYEE")
                .build();

        UserDetails mary=User.builder().
                username("mary")
                .password("{noop}test123")
                .roles("EMPLOYEE","MANAGER")
                .build();

        UserDetails susan=User.builder().
                username("susan")
                .password("{noop}test123")
                .roles("EMPLOYEE","MANAGER","ADMIN")
                .build();

        return  new InMemoryUserDetailsManager(john,mary,susan);
    }
*/


//fetching user details from database using spring security default schema tables with noop

    /*

        @Bean
        public UserDetailsManager manager(DataSource source){
            return  new JdbcUserDetailsManager(source);
        }

     */


    //fetching user detail from custom queries
    @Bean
    public UserDetailsManager manager(DataSource source){

        JdbcUserDetailsManager jdbcUserDetailsManager = new JdbcUserDetailsManager(source);
        jdbcUserDetailsManager.setUsersByUsernameQuery("select user_id,pw, active from members where user_id=?");
        jdbcUserDetailsManager.setAuthoritiesByUsernameQuery("select user_id ,role from roles where user_id=?");
        return jdbcUserDetailsManager;
    }








    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

        http.authorizeHttpRequests(configurer->
        configurer.requestMatchers(HttpMethod.GET,"/api/employees").hasRole("EMPLOYEE")
                  .requestMatchers(HttpMethod.GET,"/api/employees/**").hasRole("EMPLOYEE")
                   .requestMatchers(HttpMethod.POST,"/api/employees").hasRole("MANAGER")
                   .requestMatchers(HttpMethod.PUT,"/api/employees").hasRole("MANAGER")
                    .requestMatchers(HttpMethod.DELETE,"/api/employees/**").hasRole("ADMIN"));

       http.httpBasic(Customizer.withDefaults());

       http.csrf(csrf->csrf.disable());
       return  http.build();


    }

}

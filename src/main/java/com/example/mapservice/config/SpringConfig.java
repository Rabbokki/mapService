package com.example.mapservice.config;

import com.example.mapservice.repository.MapMemberRepository;
import com.example.mapservice.repository.MemberRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringConfig {

    @Bean
    public MemberRepository memberRepository(){
        return new MapMemberRepository();
    }
}

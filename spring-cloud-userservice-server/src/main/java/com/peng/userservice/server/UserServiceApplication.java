package com.peng.userservice.server;

import org.redisson.Redisson;
import org.redisson.api.RedissonClient;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import springfox.documentation.swagger2.annotations.EnableSwagger2;


@SpringBootApplication
@EnableDiscoveryClient
@EnableJpaAuditing
@EnableHystrix
@EnableCircuitBreaker
@Configuration
@EnableFeignClients
public class UserServiceApplication {
    @Bean
    RedissonClient redissonClient() {
        return Redisson.create();
    }
    public static void main(String[] args) {
        SpringApplication.run( UserServiceApplication.class, args );
    }
}
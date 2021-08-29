package com.example.demo.Configuration;

import java.util.UUID;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.RedisConnectionFailureException;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;

@Configuration
@EnableAutoConfiguration
public class RedisConfiguration {



    @Bean
    JedisConnectionFactory jedisConnectionFactory() {
        try {
            JedisConnectionFactory jedisConnectionFactory=new JedisConnectionFactory();
        } catch (RedisConnectionFailureException e) {
            e.printStackTrace();
        }
        return new JedisConnectionFactory();
    }


    @Bean
    public RedisTemplate<UUID, String> redisTemplate() {
        try {
            RedisTemplate<UUID, String> template = new RedisTemplate<>();
            template.setConnectionFactory(jedisConnectionFactory());
            return template;
        } catch (RedisConnectionFailureException e) {
            e.printStackTrace();
        }
        return null;
    }

} 


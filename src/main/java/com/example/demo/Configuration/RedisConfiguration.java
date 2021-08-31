package com.example.demo.Configuration;

import java.util.Map;

import com.cloudinary.utils.ObjectUtils;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.StringRedisSerializer;


@Configuration
@EnableAutoConfiguration
public class RedisConfiguration {



    @Bean
    JedisConnectionFactory jedisConnectionFactory() {
        return new JedisConnectionFactory();
    }


    @Bean
    public RedisTemplate<String, byte[]> redisTemplate() {
            RedisTemplate<String, byte[]> template = new RedisTemplate<>();
            template.setConnectionFactory(jedisConnectionFactory());
            template.setKeySerializer(new StringRedisSerializer());
            template.setValueSerializer(new ByteSerializer());
            return template;
    }


        static final Map config= ObjectUtils.asMap(
            "cloud_name", System.getenv("cloud_name"),
            "api_key", System.getenv("api_key"),
            "api_secret", System.getenv("api_secret"),
            "secure", true
        );

} 


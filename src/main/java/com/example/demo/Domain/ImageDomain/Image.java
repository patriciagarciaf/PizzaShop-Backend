package com.example.demo.Domain.ImageDomain;

import javax.persistence.Entity;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import com.example.demo.core.EntityBase;

import org.springframework.data.redis.core.RedisHash;
import org.springframework.data.redis.core.TimeToLive;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@RedisHash("Image")
public @Getter @Setter @NoArgsConstructor class Image extends EntityBase{

    
    @NotBlank
    @Size(min = 1)
    private byte[] data;

    @TimeToLive
    int timeout=60;
}

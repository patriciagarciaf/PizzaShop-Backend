package com.example.demo.Domain.ImageDomain;

import javax.persistence.Embeddable;
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
@Embeddable
public @Getter @Setter @NoArgsConstructor class Image extends EntityBase{

    @Size(min = 1)
    private byte[] data;

    @TimeToLive
    private long TTL=60*60*24;

    // @NotBlank
    private String cloudId;
    
    // @NotBlank
    private String cloudUrl;
}

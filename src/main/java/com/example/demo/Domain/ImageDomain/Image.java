package com.example.demo.Domain.ImageDomain;

import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.Transient;
import javax.validation.constraints.Size;

import com.example.demo.core.EntityBase;

import org.springframework.data.redis.core.RedisHash;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@RedisHash("Image")
@Embeddable
public @Getter @Setter @NoArgsConstructor class Image extends EntityBase{

    @Size(min = 1)
    @Transient
    private byte[] data;
}

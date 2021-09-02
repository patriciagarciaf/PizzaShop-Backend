package com.example.demo.Domain.ImageDomain;

import java.util.UUID;

import com.example.demo.Application.ImageApplication.ImageDTO;
import com.example.demo.core.FindById;

public interface ImageRepository extends FindById<Image, UUID>{
    ImageDTO save(Image image);
}

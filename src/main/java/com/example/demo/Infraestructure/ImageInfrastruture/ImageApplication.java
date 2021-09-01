package com.example.demo.Infraestructure.ImageInfrastruture;

import java.util.UUID;

import com.example.demo.Application.ImageApplication.CreateOrUpdateImageDTO;
import com.example.demo.Application.ImageApplication.ImageDTO;

public interface ImageApplication{
    public ImageDTO save(CreateOrUpdateImageDTO dto);
    public ImageDTO get(UUID id);
}

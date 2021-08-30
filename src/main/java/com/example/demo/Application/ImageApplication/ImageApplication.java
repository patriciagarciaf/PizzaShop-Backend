package com.example.demo.Application.ImageApplication;

import java.util.UUID;

public interface ImageApplication{
    public ImageDTO save(CreateOrUpdateImageDTO dto);
    public ImageDTOBytes get(UUID id);
}

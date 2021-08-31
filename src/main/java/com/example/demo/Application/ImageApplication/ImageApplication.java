package com.example.demo.Application.ImageApplication;

import java.io.IOException;
import java.util.UUID;

public interface ImageApplication{
    public ImageDTO save(CreateOrUpdateImageDTO dto);
    public ImageDTOOut get(UUID id) throws IOException;
}

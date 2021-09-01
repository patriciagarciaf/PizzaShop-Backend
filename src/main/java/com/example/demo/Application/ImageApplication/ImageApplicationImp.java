package com.example.demo.Application.ImageApplication;

import java.io.File;
import java.io.IOException;
import java.util.Map;
import java.util.UUID;

import com.cloudinary.Cloudinary;
import com.cloudinary.Transformation;
import com.cloudinary.utils.ObjectUtils;
import com.example.demo.Domain.ImageDomain.Image;
import com.example.demo.Domain.ImageDomain.ImageRepository;
import com.example.demo.core.ApplicationBase;
import com.example.demo.core.Exceptions.InternalServerErrorEnum;
import com.example.demo.core.Exceptions.InternalServerErrorException;

import org.apache.commons.io.FileUtils;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;


@Service
public class ImageApplicationImp extends ApplicationBase<Image, UUID> implements ImageApplication{

    private final RedisTemplate<String, byte[]> template;
    private final ImageRepository imageRepository;
    private final ModelMapper modelMapper;
    private final Logger logger;

    @Autowired
    public ImageApplicationImp(final ModelMapper modelMapper, final Logger logger,
                                final ImageRepository imageRepository,
                                final RedisTemplate<String, byte[]> template){
            super((id) -> imageRepository.findById(id));
            this.imageRepository=imageRepository;
            this.logger=logger;
            this.modelMapper=modelMapper;
            this.template=template;
    }

    
    @Override
    public ImageDTO save(CreateOrUpdateImageDTO dto) {
        Image image = modelMapper.map(dto, Image.class);
        image.setId(UUID.randomUUID());
        image.validate();
        this.imageRepository.save(image);
        this.logger.info(serializeObject(image, "added"));
        return modelMapper.map(image, ImageDTO.class);
    } 
    
    @Override
    public ImageDTOOut get(UUID id){
        Image image= this.findById(id);
        ImageDTOOut imageDTOOut= this.modelMapper.map(image, ImageDTOOut.class);

        return imageDTOOut;
    }


    protected String serializeObject(Image image, String msg){
        return String.format("Image {id: %s, data: %s} has been %s succesfully.",
                            image.getId(), image.getData(),
                            msg);
    }

}

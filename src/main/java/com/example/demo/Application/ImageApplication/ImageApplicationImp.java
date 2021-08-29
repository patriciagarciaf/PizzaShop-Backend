package com.example.demo.Application.ImageApplication;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

import com.cloudinary.Cloudinary;
import com.cloudinary.Transformation;
import com.cloudinary.utils.ObjectUtils;
import com.example.demo.Domain.ImageDomain.Image;
import com.example.demo.Infraestructure.ImageInfrastruture.ImageApplication;
import com.example.demo.Infraestructure.ImageInfrastruture.ImageRepository;

import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class ImageApplicationImp implements ImageApplication{

    private final RedisTemplate<UUID, String> template;
    private final ImageRepository imageRepository;
    private final ModelMapper modelMapper;
    private final Logger logger;

    @Autowired
    public ImageApplicationImp(final ModelMapper modelMapper, final Logger logger,
                                final ImageRepository imageRepository,
                                final RedisTemplate<UUID, String> template){
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
        logger.info(serializeObject(image, "added"));
        return modelMapper.map(image, ImageDTO.class);
    } 

    @Override
    public ImageDTO get(UUID id) {
        Optional<Image> imageOptional=this.imageRepository.findById(id);
        Image image=imageOptional.get();
        return this.modelMapper.map(image, ImageDTO.class);
    }

    private String serializeObject(Image image, String msg){
        return String.format("Image {id: %s, data: %s} has been %s succesfully.",
                            image.getId(), image.getData(),
                            msg);
    }

    public File convert(MultipartFile multipartFile) throws IOException {
        File file = new File(multipartFile.getOriginalFilename());
        FileOutputStream fo = new FileOutputStream(file);
        fo.write(multipartFile.getBytes());
        fo.close();
        return file;
    }
}

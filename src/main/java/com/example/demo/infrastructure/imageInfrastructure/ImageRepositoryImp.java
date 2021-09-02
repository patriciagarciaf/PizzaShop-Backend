package com.example.demo.Infraestructure.ImageInfrastruture;

import java.time.Duration;
import java.util.Optional;
import java.util.UUID;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import com.example.demo.Application.ImageApplication.ImageDTO;
import com.example.demo.Domain.ImageDomain.Image;
import com.example.demo.Domain.ImageDomain.ImageRepository;
import com.example.demo.core.Exceptions.InternalServerErrorEnum;
import com.example.demo.core.Exceptions.InternalServerErrorException;

import org.modelmapper.ModelMapper;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;



@Repository
public class ImageRepositoryImp implements ImageRepository{

    Image image;
    private final RedisTemplate<String, byte[]> template;
    private final ModelMapper modelMapper;

    public ImageRepositoryImp(final RedisTemplate<String, byte[]> template, final ModelMapper modelMapper){
        this.template=template;
        this.modelMapper=modelMapper;
    }


    @Override
    public ImageDTO save(Image image) {
        try {
            this.template.opsForValue().set(image.getId().toString(), image.getData(), Duration.ofDays(2));
        }catch (Exception e) {
            throw new InternalServerErrorException(InternalServerErrorEnum.REDIRECT);
        } finally{
            if (!this.template.getConnectionFactory().getConnection().isClosed()){
                this.template.getConnectionFactory().getConnection().close();
            }
        }
        uploadToCloudinary(image);
        return this.modelMapper.map(image, ImageDTO.class);
    }
    
    
    public void uploadToCloudinary(Image image){
        try {
            Cloudinary cloudinary=new Cloudinary();
            cloudinary.uploader().upload(image.getData(), ObjectUtils.asMap("public_id", image.getId().toString()));
        } catch (Exception e) {
            throw new InternalServerErrorException(InternalServerErrorEnum.REDIRECT);
        }
    }


    @Override
    public Optional<Image> findById(UUID id) {
        try {
           byte[] bytes= this.template.opsForValue().get(id.toString());
            if (bytes==null) {
                return Optional.of(null);
            }
            Image image= new Image();
            image.setId(id);
            image.setData(bytes);
            return Optional.of(image);
        } catch (Exception e) {
            throw new InternalServerErrorException(InternalServerErrorEnum.REDIRECT);
        } finally{
            if (!this.template.getConnectionFactory().getConnection().isClosed()){
                this.template.getConnectionFactory().getConnection().close();
            } 
        }
    }


    // @Override
    // public boolean exists(String field) {
    //     return this.exists(image.getData().toString());
    // }

}

package com.example.demo.Infraestructure.ImageInfrastruture;

import java.util.UUID;

//import com.example.demo.Domain.ImageDomain.Image;

import com.example.demo.Domain.ImageDomain.Image;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ImageRepository extends CrudRepository<Image, UUID>{

}

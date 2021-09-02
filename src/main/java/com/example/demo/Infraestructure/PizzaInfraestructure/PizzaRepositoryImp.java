package com.example.demo.Infraestructure.PizzaInfraestructure;

import com.cloudinary.Cloudinary;
import com.example.demo.Domain.ImageDomain.Image;
import com.example.demo.Domain.PizzaDomain.Pizza;
import com.example.demo.Domain.PizzaDomain.PizzaProjection;
import com.example.demo.Domain.PizzaDomain.PizzaRepositoryRead;
import com.example.demo.Domain.PizzaDomain.PizzaRepositoryWrite;
import com.example.demo.core.Exceptions.InternalServerErrorEnum;
import com.example.demo.core.Exceptions.InternalServerErrorException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public class PizzaRepositoryImp implements PizzaRepositoryWrite, PizzaRepositoryRead {

    private PizzaJPARepository pizzaJPARepository;
    private final RedisTemplate<String, byte[]> template;

    @Autowired
    public PizzaRepositoryImp(final PizzaJPARepository pizzaJPARepository,
                            final RedisTemplate<String, byte[]> template){
        this.pizzaJPARepository = pizzaJPARepository;
        this.template=template;
    }

    @Override
    public void add(Pizza pizza) {
        Image image= pizza.getImage();
        try {
            byte[] bytes = this.template.opsForValue().get(image.getId().toString());
            //  if (bytes==null) {
            //  }
            image.setData(bytes);
            Cloudinary cloudinary=new Cloudinary();
            String cloudUrl= cloudinary.url().secure(true).publicId(image.getId()).generate();
            image.setUrl(cloudUrl);
         } catch (Exception e) {
             throw new InternalServerErrorException(InternalServerErrorEnum.REDIRECT);
         } finally{
             if (!this.template.getConnectionFactory().getConnection().isClosed()){
                 this.template.getConnectionFactory().getConnection().close();
             } 
         }
        pizza.setImage(image);
        this.pizzaJPARepository.save(pizza);
    }

    @Override
    public void update(Pizza pizza) {
        Image image= pizza.getImage();
        try {
            byte[] bytes = this.template.opsForValue().get(image.getId().toString());
            //  if (bytes==null) {
            //  }
            image.setData(bytes);
            // Cloudinary cloudinary=new Cloudinary();
            // String cloudUrl= cloudinary.url().secure(true).publicId(image.getId()).generate();
            // image.setUrl(cloudUrl);
         } catch (Exception e) {
             throw new InternalServerErrorException(InternalServerErrorEnum.REDIRECT);
         } finally{
             if (!this.template.getConnectionFactory().getConnection().isClosed()){
                 this.template.getConnectionFactory().getConnection().close();
             } 
         }
        pizza.setImage(image);
        this.pizzaJPARepository.save(pizza);
    }

    @Override
    public Optional<Pizza> findById(UUID id) {
        return this.pizzaJPARepository.findById(id);
    }

    @Override
    public List<PizzaProjection> getAll(String name, int page, int size) {
        return this.pizzaJPARepository.findByCriteria(name,
                PageRequest.of(page, size, Sort.by("name").descending()));
    }

    @Override
    public boolean exists(String name) {
        return this.pizzaJPARepository.exists(name);
    }

    @Override
    public void delete(Pizza pizza) {
        this.pizzaJPARepository.delete(pizza);
    }

}

package com.example.demo.Controller;

import java.io.IOException;
import java.util.UUID;

import javax.validation.Valid;

import com.example.demo.Application.ImageApplication.CreateOrUpdateImageDTO;
import com.example.demo.Application.ImageApplication.ImageApplicationImp;
import com.example.demo.Application.ImageApplication.ImageDTO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/api/v1/images")
public class ImageController {
    private final ImageApplicationImp imageApplicationImp;
 
    @Autowired
    public ImageController(ImageApplicationImp imageApplicationImp) {
        this.imageApplicationImp = imageApplicationImp;
    }
 
    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> create(@Valid @RequestParam("image") MultipartFile file) throws IOException {
 
        CreateOrUpdateImageDTO dto = new CreateOrUpdateImageDTO();
        dto.setData(file.getBytes());
        ImageDTO imageDto = imageApplicationImp.save(dto);
        return ResponseEntity.status(201).body(imageDto);
    }


    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE, path = "/{id}")
    public ResponseEntity<?> get(@Valid @PathVariable UUID id) {
        ImageDTO imageDto = imageApplicationImp.get(id);
        return ResponseEntity.ok(imageDto);
    }
}

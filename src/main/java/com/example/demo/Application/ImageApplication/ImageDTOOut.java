package com.example.demo.Application.ImageApplication;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

public @Getter @Setter @NoArgsConstructor class ImageDTOOut extends ImageDTO{

    private byte[] data;

    private String cloudId; 
    
    private String cloudUrl;
    
    
}

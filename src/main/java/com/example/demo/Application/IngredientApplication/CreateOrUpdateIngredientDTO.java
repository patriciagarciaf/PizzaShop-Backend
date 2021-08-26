package com.example.demo.Application.IngredientApplication;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.validation.constraints.*;

import org.springframework.validation.annotation.Validated;

import lombok.*;

@Validated
public @NoArgsConstructor @Getter @Setter   class CreateOrUpdateIngredientDTO {
    @NotBlank
    @Size(min = 3, max = 255)
    @Column(nullable = false, unique = true) 
    public String name;

    @DecimalMin(value = "0.0", inclusive = false)
    @Column(nullable = false)
    public BigDecimal price;
}

package com.qortmdcks.crudpra.payload;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class CarDto {
    private Long id;

    @NotEmpty
    @Size(min = 2, message = "Car name should have at least 2characters")
    private String name;

    private Integer price = 0;
}

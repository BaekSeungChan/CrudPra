package com.qortmdcks.crudpra.payload;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.Setter;

@Data
public class CategoryCarDto {
    private Long id;

    @NotEmpty
    @Size(min = 2, message = "car name")
    private String name;

    private String color = "white";
}

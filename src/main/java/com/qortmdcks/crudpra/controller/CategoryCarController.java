package com.qortmdcks.crudpra.controller;

import com.qortmdcks.crudpra.payload.CategoryCarDto;
import com.qortmdcks.crudpra.service.CategoryCarService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/api/categorycar")
public class CategoryCarController {
    private CategoryCarService categoryCarService;

    public CategoryCarController(CategoryCarService categoryCarService){
        this.categoryCarService = categoryCarService;
    }

    @PostMapping
    public ResponseEntity<CategoryCarDto> createCategoryCar(@Valid @RequestBody CategoryCarDto categoryCarDto){
        return new ResponseEntity<>(categoryCarService.createCategoryCar(categoryCarDto), HttpStatus.OK);
    }
}

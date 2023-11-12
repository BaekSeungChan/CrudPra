package com.qortmdcks.crudpra.controller;

import com.qortmdcks.crudpra.payload.CategoryCarDto;
import com.qortmdcks.crudpra.service.CategoryCarService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


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

    @GetMapping("/all")
        public ResponseEntity<List<CategoryCarDto>> getAllCategoryCar(){
            return ResponseEntity.ok(categoryCarService.getAllCategoryCar());
    }

    @GetMapping("/{id}")
    public ResponseEntity<CategoryCarDto> getCategoryCarById(@PathVariable(name = "id") long id){
        return ResponseEntity.ok(categoryCarService.getCategoryCarById(id));
    }
}

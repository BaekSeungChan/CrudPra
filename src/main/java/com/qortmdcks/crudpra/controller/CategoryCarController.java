package com.qortmdcks.crudpra.controller;

import com.qortmdcks.crudpra.payload.CategoryCarDto;
import com.qortmdcks.crudpra.service.CategoryCarService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
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

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteCategoryCarById(@PathVariable(name = "id") long id){
        categoryCarService.deleteCategoryCarById(id);
        return new ResponseEntity<>("deleted post", HttpStatus.OK);
    }

    @PutMapping("/{id}")
    @Operation(
            summary = "Update Car",
            description = "Update Car API"
    )
    @ApiResponse(responseCode = "200", description = "Update")
    public ResponseEntity<CategoryCarDto> updateCategoryCar(@PathVariable(name = "id") long id, @Valid @RequestBody CategoryCarDto categoryCarDto){
        CategoryCarDto categoryCarResponse = categoryCarService.updateCategoryCar(categoryCarDto, id);

        return new ResponseEntity<>(categoryCarResponse, HttpStatus.OK);
    }
}

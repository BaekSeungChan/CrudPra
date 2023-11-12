package com.qortmdcks.crudpra.controller;

import com.qortmdcks.crudpra.entity.Car;
import com.qortmdcks.crudpra.payload.CarDto;
import com.qortmdcks.crudpra.service.CarService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/car")
@Tag(name = "Car API's")
public class CarContorller {

    private CarService carService;

    private CarContorller(CarService carService){
        this.carService = carService;
    }

    @PostMapping
    @Operation(
            summary = "Create Car",
            description = "Create Car API"
    )
    @ApiResponse(responseCode = "201", description = "Created")
    public ResponseEntity<CarDto> createCar(@Valid @RequestBody CarDto carDto){
        return new ResponseEntity<>(carService.createCar(carDto), HttpStatus.OK);
    }

    @GetMapping("/all")
    @Operation(
            summary = "Get All Car",
            description = "Get All Car API"
    )
    @ApiResponse(responseCode = "200", description = "Get All Car")
    public ResponseEntity<List<CarDto>> getAllCar(){
        return ResponseEntity.ok(carService.getAllCar());
    }

    @GetMapping("/{id}")
    @Operation(
            summary = "Get Car By Id",
            description = "Get Car By Id API"
    )
    @ApiResponse(responseCode = "200", description = "OK")
    public ResponseEntity<CarDto> getCarById(@PathVariable(name = "id") long id){
        return ResponseEntity.ok(carService.getCarById(id));
    }

    @DeleteMapping("/{id}")
    @Operation(
            summary = "Delete Car",
            description = "Delete Car API"
    )
    @ApiResponse(responseCode = "200", description = "Deleted")
    public ResponseEntity<String> deleteCarById(@PathVariable(name = "id") long id){
        carService.deleteCarById(id);
        return new ResponseEntity<>("deleted post", HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<CarDto> updateCar(@PathVariable(name = "id") long id, @Valid @RequestBody CarDto carDto){
        CarDto carResponse = carService.updateCar(carDto, id);
        return new ResponseEntity<>(carResponse, HttpStatus.OK);
    }
}

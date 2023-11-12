package com.qortmdcks.crudpra.controller;

import com.qortmdcks.crudpra.entity.Car;
import com.qortmdcks.crudpra.payload.CarDto;
import com.qortmdcks.crudpra.service.CarService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/car")
public class CarContorller {

    private CarService carService;

    private CarContorller(CarService carService){
        this.carService = carService;
    }

    @PostMapping
    public ResponseEntity<CarDto> createCar(@Valid @RequestBody CarDto carDto){
        return new ResponseEntity<>(carService.createCar(carDto), HttpStatus.OK);
    }
}

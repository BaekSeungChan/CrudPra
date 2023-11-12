package com.qortmdcks.crudpra.service;

import com.qortmdcks.crudpra.payload.CarDto;

import java.util.List;

public interface CarService {

    CarDto createCar(CarDto carDto);

    List<CarDto> getAllCar();

    CarDto getCarById(long id);

    void deleteCarById(long id);
}

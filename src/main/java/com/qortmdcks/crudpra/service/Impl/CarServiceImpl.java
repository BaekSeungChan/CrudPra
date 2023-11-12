package com.qortmdcks.crudpra.service.Impl;

import com.qortmdcks.crudpra.entity.Car;
import com.qortmdcks.crudpra.payload.CarDto;
import com.qortmdcks.crudpra.repository.CarRepository;
import com.qortmdcks.crudpra.service.CarService;
import jakarta.validation.Valid;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

@Service
public class CarServiceImpl implements CarService {
    private CarRepository carRepository;
    private ModelMapper modelMapper;

    public CarServiceImpl(CarRepository carRepository, ModelMapper modelMapper){
        this.carRepository = carRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public CarDto createCar(CarDto carDto){
        Car car = modelMapper.map(carDto, Car.class);
        Car saveCar = carRepository.save(car);

        return modelMapper.map(saveCar, CarDto.class);
    }

}

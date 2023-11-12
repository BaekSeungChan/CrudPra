package com.qortmdcks.crudpra.service.Impl;

import com.qortmdcks.crudpra.entity.Car;
import com.qortmdcks.crudpra.payload.CarDto;
import com.qortmdcks.crudpra.repository.CarRepository;
import com.qortmdcks.crudpra.service.CarService;
import jakarta.validation.Valid;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.stream.Collectors;

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

    @Override
    public List<CarDto> getAllCar(){
        List<Car> cars = carRepository.findAll();

        return cars.stream().map((car) -> modelMapper.map(car, CarDto.class)).collect(Collectors.toList());
    }

    @Override
    public CarDto getCarById(long id){
        Car car = carRepository.findById(id).orElseThrow(() -> new RuntimeException("No id"));

        return modelMapper.map(car, CarDto.class);
    }

    @Override
    public void deleteCarById(long id){
        Car car = carRepository.findById(id).orElseThrow(() -> new RuntimeException("No id"));
        carRepository.delete(car);
    }

    @Override
    public CarDto updateCar(CarDto carDto, long id){
        Car car = carRepository.findById(id).orElseThrow(() -> new RuntimeException("No id"));

        car.setName(carDto.getName());
        car.setPrice(carDto.getPrice());

        Car saveCar = carRepository.save(car);

        return modelMapper.map(saveCar, CarDto.class);
    }

}

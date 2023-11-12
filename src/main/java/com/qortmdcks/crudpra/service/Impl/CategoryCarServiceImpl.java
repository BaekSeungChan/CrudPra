package com.qortmdcks.crudpra.service.Impl;

import com.qortmdcks.crudpra.entity.CategoryCar;
import com.qortmdcks.crudpra.payload.CategoryCarDto;
import com.qortmdcks.crudpra.repository.CategoryCarRepository;
import com.qortmdcks.crudpra.service.CategoryCarService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CategoryCarServiceImpl implements CategoryCarService {
    private CategoryCarRepository categoryCarRepository;

    private ModelMapper modelMapper;

    public CategoryCarServiceImpl(CategoryCarRepository categoryCarRepository, ModelMapper modelMapper){
        this.categoryCarRepository = categoryCarRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public CategoryCarDto createCategoryCar(CategoryCarDto categoryCarDto){
        CategoryCar categoryCar = modelMapper.map(categoryCarDto, CategoryCar.class);
        CategoryCar saveCategoryCar = categoryCarRepository.save(categoryCar);

        return modelMapper.map(saveCategoryCar, CategoryCarDto.class);
    }

    @Override
    public List<CategoryCarDto> getAllCategoryCar(){
        List<CategoryCar> categoryCars = categoryCarRepository.findAll();

        return categoryCars.stream().map((categoryCar) -> modelMapper.map(categoryCar, CategoryCarDto.class)).collect(Collectors.toList());
    }

    @Override
    public CategoryCarDto getCategoryCarById(long id){
        CategoryCar categoryCar = categoryCarRepository.findById(id).orElseThrow(() -> new RuntimeException("No id"));

        return  modelMapper.map(categoryCar, CategoryCarDto.class);
    }

    @Override
    public void deleteCategoryCarById(long id){
        CategoryCar categoryCar = categoryCarRepository.findById(id).orElseThrow(() -> new RuntimeException("No id"));
        categoryCarRepository.delete(categoryCar);
    }

    @Override
    public CategoryCarDto updateCategoryCar(CategoryCarDto categoryCarDto, long id){
        CategoryCar categoryCar = categoryCarRepository.findById(id).orElseThrow(() -> new RuntimeException("No id"));

        categoryCar.setColor(categoryCarDto.getColor());
        categoryCar.setName(categoryCarDto.getName());

        CategoryCar saveCategoryCar = categoryCarRepository.save(categoryCar);

        return modelMapper.map(saveCategoryCar, CategoryCarDto.class);
    }

}

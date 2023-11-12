package com.qortmdcks.crudpra.service.Impl;

import com.qortmdcks.crudpra.entity.CategoryCar;
import com.qortmdcks.crudpra.payload.CategoryCarDto;
import com.qortmdcks.crudpra.repository.CategoryCarRepository;
import com.qortmdcks.crudpra.service.CategoryCarService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

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

}
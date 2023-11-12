package com.qortmdcks.crudpra.service;

import com.qortmdcks.crudpra.entity.CategoryCar;
import com.qortmdcks.crudpra.payload.CategoryCarDto;

import java.util.List;

public interface CategoryCarService {

    CategoryCarDto createCategoryCar(CategoryCarDto categoryCarDto);

    List<CategoryCarDto> getAllCategoryCar();

    CategoryCarDto getCategoryCarById(long id);

    void deleteCategoryCarById(long id);

    CategoryCarDto updateCategoryCar(CategoryCarDto categoryCarDto, long id);
}

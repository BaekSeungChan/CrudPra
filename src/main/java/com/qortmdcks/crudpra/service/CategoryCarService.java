package com.qortmdcks.crudpra.service;

import com.qortmdcks.crudpra.payload.CategoryCarDto;

import java.util.List;

public interface CategoryCarService {

    CategoryCarDto createCategoryCar(CategoryCarDto categoryCarDto);

    List<CategoryCarDto> getAllCategoryCar();
}

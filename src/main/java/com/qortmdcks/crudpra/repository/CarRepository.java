package com.qortmdcks.crudpra.repository;

import com.qortmdcks.crudpra.entity.Car;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CarRepository extends JpaRepository<Car, Long> {
}

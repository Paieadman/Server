package com.company.repository;

import com.company.entity.DishEntity;
import org.springframework.data.repository.CrudRepository;


public interface DishRepository extends CrudRepository<DishEntity, Integer> {
    @Override
    Iterable<DishEntity> findAll();
}

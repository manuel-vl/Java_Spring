package com.projectjavaspring.marketapi.persistence.crud;

import com.projectjavaspring.marketapi.persistence.entity.Producto;
import org.springframework.data.repository.CrudRepository;

public interface IProductoCrudRepository extends CrudRepository<Producto, Integer> {
}

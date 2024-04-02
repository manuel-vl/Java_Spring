package com.projectjavaspring.marketapi.persistence.crud;

import com.projectjavaspring.marketapi.persistence.entity.Compra;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface ICompraCrudRepository extends CrudRepository<Compra, Integer> {
    // QUERY METHODS
    Optional<List<Compra>> findByIdCliente(String idCliente);
}

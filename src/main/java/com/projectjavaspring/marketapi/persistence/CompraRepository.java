package com.projectjavaspring.marketapi.persistence;

import com.projectjavaspring.marketapi.domain.Purchase;
import com.projectjavaspring.marketapi.domain.repository.PurchaseRepository;
import com.projectjavaspring.marketapi.persistence.crud.ICompraCrudRepository;
import com.projectjavaspring.marketapi.persistence.entity.Compra;
import com.projectjavaspring.marketapi.persistence.mapper.PurchaseMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class CompraRepository implements PurchaseRepository {
    @Autowired
    private ICompraCrudRepository compraCrudRepository;
    @Autowired
    private PurchaseMapper mapper;

    @Override
    public List<Purchase> getAll() {
        return mapper.toPurchases((List<Compra>) compraCrudRepository.findAll());
    }

    @Override
    public Optional<List<Purchase>> getByClient(String clientId) {
        return compraCrudRepository.findByIdCliente(clientId)
                .map(compras -> mapper.toPurchases(compras));
    }

    @Override
    public Purchase save(Purchase purchase) {
        Compra compra=mapper.toCompra(purchase);
        compra.getComprasProductos().forEach(producto -> producto.setCompra(compra));
        return mapper.toPurchase(compraCrudRepository.save(compra));
    }
}

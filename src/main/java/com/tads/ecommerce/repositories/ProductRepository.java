package com.tads.ecommerce.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.tads.ecommerce.entities.Product;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
}

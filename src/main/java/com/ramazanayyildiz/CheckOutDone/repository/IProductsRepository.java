package com.ramazanayyildiz.CheckOutDone.repository;

import com.ramazanayyildiz.CheckOutDone.entity.Products;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IProductsRepository extends JpaRepository<Products, Integer> {
}

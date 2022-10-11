package com.example.productservice.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import com.example.productservice.model.productModel;

public interface productRepository extends JpaRepository<productModel, Long> {
        List<productModel> findByNama(String nama);
}

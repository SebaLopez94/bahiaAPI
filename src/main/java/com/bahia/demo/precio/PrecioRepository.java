package com.bahia.demo.precio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface PrecioRepository extends JpaRepository<Precio, Long> {


    @Query("SELECT p FROM Precio p" +
            " WHERE p.startDate = ?1" +
            " AND   p.productId  = ?2" +
            " AND   p.brand = ( SELECT b FROM Brand b Where b.code = ?3)" +
            " ORDER BY p.priority DESC")
    List<Precio> findByStartDateAndProductIdAndBrandCode(LocalDateTime startDate, Long productId, String brandCode);

}



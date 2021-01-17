package com.bahia.demo.precio;


import com.bahia.demo.precio.dto.PrecioDTO;

import java.time.LocalDateTime;


public interface PrecioUseCase {

    public PrecioDTO retrievePrecio(LocalDateTime startDate, Long productId, String brandCode);
}

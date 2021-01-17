package com.bahia.demo.precio;

import com.bahia.demo.precio.dto.PrecioDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.time.LocalDateTime;
import java.util.List;

@Transactional
@Service
public class PrecioService implements PrecioUseCase {

    @Autowired
    private PrecioRepository precioRepository;

    @Override
    public PrecioDTO retrievePrecio(LocalDateTime startDate, Long productId, String brandCode) {
        List<Precio> precios = precioRepository.findByStartDateAndProductIdAndBrandCode(startDate, productId, brandCode);
        return (!precios.isEmpty()) ? buildPrecioDTOByPrecio(precios.get(0)) : null;
    }

    private PrecioDTO buildPrecioDTOByPrecio(Precio precio) {
        return PrecioDTO.builder()
                .brandName(precio.getBrand().getName())
                .productId(precio.getProductId())
                .priceList(precio.getPriceList())
                .startDate(precio.getStartDate())
                .endDate(precio.getEndDate())
                .price(precio.getPrice())
                .curr(precio.getCurr())
                .build();
    }

}

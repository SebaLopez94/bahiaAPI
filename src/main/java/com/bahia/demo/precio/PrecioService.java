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
    public PrecioDTO findByStartDateAndProductIdAndBrandCode(LocalDateTime startDate, Long productId, String brandCode) {
        List<Precio> precios = precioRepository.findByStartDateAndProductIdAndBrandCode(startDate, productId, brandCode);
        //TODO Add more validations and specific exceptions
        return (!precios.isEmpty()) ? buildPrecioDTOByPrecio(precios.get(0)) : null;
    }

    /**
     * Using the Builder Pattern provided by Lombok with the annotation @Builder,
     * to map the domain object to DTO
     */
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

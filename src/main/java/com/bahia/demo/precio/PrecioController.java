package com.bahia.demo.precio;

import com.bahia.demo.precio.dto.PrecioDTO;
import com.bahia.demo.utilities.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;


@RestController
@RequestMapping(value = "/api/precio")
public class PrecioController {

    @Autowired
    private PrecioService precioService;


    @GetMapping("/")
    public PrecioDTO retrievePrecio(@RequestParam(value = "startDate") @DateTimeFormat(pattern = Constants.PRICE_START_DATE_FORMAT) LocalDateTime startDate,
                                     @RequestParam(value = "productId") Long productId,
                                     @RequestParam(value = "brand") String brandCode) {

        return precioService.retrievePrecio(startDate, productId, brandCode);
    }


}

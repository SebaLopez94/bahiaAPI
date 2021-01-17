package com.bahia.demo.precio;


import com.bahia.demo.precio.dto.PrecioDTO;
import com.bahia.demo.utilities.Constants;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;

import static org.junit.Assert.*;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;


@SpringBootTest
@Sql("/test.sql")
@AutoConfigureMockMvc
class PrecioServiceTest {

    @Autowired
    PrecioService precioService;


    @ParameterizedTest
    @ValueSource(strings = {"2020-06-14-00:00", "2020-06-15-00:00"})
    void givenStartDateWhenFindPreciosThenNonEmpty(String date) {
        //given
        LocalDateTime startDate = LocalDateTime.parse(date, DateTimeFormatter.ofPattern(Constants.PRICE_START_DATE_FORMAT));

        //when
        PrecioDTO precioDTO = precioService.findByStartDateAndProductIdAndBrandCode(startDate, 35455L, "ZARA");

        //then
        assertEquals(true, precioDTO != null);
    }


    @ParameterizedTest
    @ValueSource(strings = {"2020-06-14-16:00", "2020-06-14-21:00", "2020-06-16-21:00"})
        // six numbers
    void givenStartDateWhenFindPreciosThenEmpty(String date) {
        LocalDateTime startDate = LocalDateTime.parse(date, DateTimeFormatter.ofPattern(Constants.PRICE_START_DATE_FORMAT));
        PrecioDTO precioDTO = precioService.findByStartDateAndProductIdAndBrandCode(startDate, 35455L, "ZARA");
        assertEquals(false, precioDTO != null);
    }


    //TODO Create more Unit Test and test other layers

}

package com.cajarcol.currencyconverter.modelo;

public record ConversionMoneda(String base_code,
                               String target_code,
                               double conversion_rate,
                               double conversion_result) {
}

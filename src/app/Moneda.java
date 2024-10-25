package app;

import java.util.Map;

public record Moneda(
         Map<String, Double> conversion_rates //map que contiene las monedas convertidas de la consulta
) {}

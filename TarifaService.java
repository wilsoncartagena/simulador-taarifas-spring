package com.ejercicio.mavenproject1;

import org.springframework.stereotype.Service;

@Service
public class TarifaService {

    /**
     * Calcula la liquidación total aplicando un porcentaje de descuento.
     */
    public double calcularLiquidacion(double tarifaBase, double porcentajeDescuento) {
        double descuento = tarifaBase * porcentajeDescuento;
        return tarifaBase - descuento;
    }

    /**
     * Calcula la liquidación con recargo por pago extemporáneo.
     */
    public double calcularRecargo(double tarifaBase, double porcentajeRecargo) {
        return tarifaBase + (tarifaBase * porcentajeRecargo);
    }
}
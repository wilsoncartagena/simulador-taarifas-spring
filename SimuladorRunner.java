package com.ejercicio.mavenproject1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class SimuladorRunner implements CommandLineRunner {

    // Inyección de dependencias con @Autowired
    @Autowired
    private TarifaService tarifaService;

    // Inyección de parámetros con @Value (con valores por defecto)
    @Value("${simulador.tarifa.base:150000.0}")
    private double tarifaBase;

    @Value("${simulador.descuento.promedio:0.10}")
    private double descuentoConfigurado;

    @Override
    public void run(String... args) throws Exception {
        System.out.println("\n==================================================");
        System.out.println("  SIMULADOR DE TARIFAS Y LIQUIDACIÓN INSTITUCIONAL ");
        System.out.println("==================================================");

        double valorProntoPago = tarifaService.calcularLiquidacion(tarifaBase, descuentoConfigurado);
        double valorConRecargo = tarifaService.calcularRecargo(tarifaBase, 0.15); // 15% recargo

        System.out.println(" Tarifa Base: $" + tarifaBase);
        System.out.println(" Descuento Aplicado: " + (descuentoConfigurado * 100) + "%");
        System.out.println("--------------------------------------------------");
        System.out.println(" Total Pronto Pago: $" + valorProntoPago);
        System.out.println(" Total Extemporáneo: $" + valorConRecargo);
        System.out.println("==================================================\n");
    }
}
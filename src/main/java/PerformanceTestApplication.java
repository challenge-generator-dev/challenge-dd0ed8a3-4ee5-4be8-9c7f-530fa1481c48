package com.example.reto;

import com.fasterxml.jackson.databind.ObjectMapper;
import adapter.outbound.ReportStoragePort;
import core.LoadTestExecutor;
import core.PercentileThresholdAnalyzer;
import core.PerformanceReportGenerator;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/*
 * Punto de entrada de la aplicación de pruebas de rendimiento.
 * Arquitectura hexagonal: core/ contiene la lógica de análisis y los modelos,
 * adapter/ contiene los adaptadores de salida (JMeter, almacenamiento de reportes).
 * Los beans se registran aquí; cada colaborador se inyecta por constructor.
 */
@SpringBootApplication
@Configuration
public class PerformanceTestApplication {

    public static void main(String[] args) {
        SpringApplication.run(PerformanceTestApplication.class, args);
    }

    @Bean
    public LoadTestExecutor loadTestExecutor() {
        return new LoadTestExecutor(null);
    }

    @Bean
    public PercentileThresholdAnalyzer percentileThresholdAnalyzer() {
        return new PercentileThresholdAnalyzer();
    }

    @Bean
    public PerformanceReportGenerator performanceReportGenerator(ReportStoragePort reportStoragePort) {
        return new PerformanceReportGenerator(reportStoragePort);
    }

    @Bean
    public ObjectMapper objectMapper() {
        return new ObjectMapper();
    }
}
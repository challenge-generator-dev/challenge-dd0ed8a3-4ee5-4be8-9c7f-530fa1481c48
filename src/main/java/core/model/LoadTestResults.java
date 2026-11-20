package core.model;

import java.util.Collections;
import java.util.List;
import java.util.Map;

/**
 * Resultados agregados de una ejecucion de prueba de carga.
 * Modelo inmutable: las latencias se exponen como copias de solo lectura.
 */
public record LoadTestResults(
        String testId,
        int totalRequests,
        int failedRequests,
        double throughputPerSecond,
        Map<String, List<Long>> endpointLatencies,
        long testDurationMs
) {

    public LoadTestResults {
        if (testId == null || testId.isBlank()) {
            throw new IllegalArgumentException("testId es obligatorio");
        }
        if (totalRequests < 0 || failedRequests < 0) {
            throw new IllegalArgumentException("Los contadores de requests no pueden ser negativos");
        }
        if (failedRequests > totalRequests) {
            throw new IllegalArgumentException("Los requests fallidos no pueden superar el total");
        }
        endpointLatencies = endpointLatencies == null
                ? Map.of()
                : Collections.unmodifiableMap(endpointLatencies);
    }

    /** Tasa de error entre 0.0 y 1.0. Sin requests devuelve 0.0. */
    public double errorRate() {
        if (totalRequests == 0) {
            return 0.0;
        }
        return (double) failedRequests / totalRequests;
    }
}
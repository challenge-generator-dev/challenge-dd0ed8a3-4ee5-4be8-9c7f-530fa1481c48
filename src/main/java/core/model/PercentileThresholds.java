package core.model;

import lombok.Builder;
import lombok.Value;

import java.util.Map;

/**
 * Umbrales de latencia por percentil (p95 y p99, en milisegundos).
 *
 * Interpretación de percentiles: el p95 indica la latencia que no superan el 95 %
 * de las requests; el p99 indica la que no superan el 99 %. Un p99 alto con p95
 * bajo señala colas de latencia: unas pocas requests son muy lentas.
 *
 * Identificación del cuello de botella: el endpoint cuyo percentil supera su umbral
 * (específico si existe, o el p95 global en caso contrario) con mayor exceso relativo
 * es el candidato a cuello de botella.
 */
@Value
@Builder
public class PercentileThresholds {
    private final double p95ThresholdMs;
    private final double p99ThresholdMs;
    private final Map<String, Double> endpointSpecificThresholds;

    public static class PercentileThresholdsBuilder {
        public PercentileThresholds build() {
            if (p95ThresholdMs <= 0) {
                throw new IllegalArgumentException("P95 threshold must be positive");
            }
            if (p99ThresholdMs <= 0) {
                throw new IllegalArgumentException("P99 threshold must be positive");
            }
            if (p99ThresholdMs < p95ThresholdMs) {
                throw new IllegalArgumentException("P99 threshold must be greater than or equal to P95 threshold");
            }
            return new PercentileThresholds(p95ThresholdMs, p99ThresholdMs, endpointSpecificThresholds);
        }
    }

    public double getThresholdForPercentile(int percentile) {
        return switch (percentile) {
            case 95 -> p95ThresholdMs;
            case 99 -> p99ThresholdMs;
            default -> throw new IllegalArgumentException("Unsupported percentile: " + percentile);
        };
    }

    public double getEndpointThreshold(String endpoint) {
        if (endpointSpecificThresholds != null && endpointSpecificThresholds.containsKey(endpoint)) {
            return endpointSpecificThresholds.get(endpoint);
        }
        return p95ThresholdMs;
    }
}
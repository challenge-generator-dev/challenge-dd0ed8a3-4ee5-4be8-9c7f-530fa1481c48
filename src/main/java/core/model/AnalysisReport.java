package core.model;

import java.util.List;
import java.util.Map;
import java.util.Optional;

/**
 * Resultado del análisis de percentiles sobre una ejecución de carga.
 * Es inmutable: lo construye el analizador y lo consume el generador de reportes.
 */
public record AnalysisReport(
        String testId,
        Map<String, Double> p95ByEndpoint,
        Map<String, Double> p99ByEndpoint,
        List<String> violations,
        Optional<String> bottleneck
) {
    public AnalysisReport {
        p95ByEndpoint = p95ByEndpoint == null ? Map.of() : Map.copyOf(p95ByEndpoint);
        p99ByEndpoint = p99ByEndpoint == null ? Map.of() : Map.copyOf(p99ByEndpoint);
        violations = violations == null ? List.of() : List.copyOf(violations);
        bottleneck = bottleneck == null ? Optional.empty() : bottleneck;
    }

    public boolean hasViolations() {
        return !violations.isEmpty();
    }

    public boolean hasBottleneck() {
        return bottleneck.isPresent();
    }
}
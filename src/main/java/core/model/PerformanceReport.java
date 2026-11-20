package core.model;

import java.time.Instant;
import java.util.List;

// Reporte final de una corrida de pruebas de rendimiento, listo para persistir o presentar.
public record PerformanceReport(
        String testId,
        Instant generatedAt,
        long totalRequests,
        double errorRate,
        double p95Ms,
        double p99Ms,
        boolean hasViolations,
        List<String> bottleneckEndpoints) {

    public PerformanceReport {
        if (testId == null || testId.isBlank()) {
            throw new IllegalArgumentException("El testId del reporte es obligatorio");
        }
        if (errorRate < 0 || errorRate > 1) {
            throw new IllegalArgumentException("La tasa de error debe estar entre 0 y 1");
        }
        generatedAt = generatedAt == null ? Instant.now() : generatedAt;
        bottleneckEndpoints = bottleneckEndpoints == null ? List.of() : List.copyOf(bottleneckEndpoints);
    }

    public boolean isHealthy() {
        return !hasViolations && bottleneckEndpoints.isEmpty() && errorRate == 0.0;
    }

    public String summaryLine() {
        return String.format(
                "test=%s requests=%d errorRate=%.4f p95=%.2fms p99=%.2fms violaciones=%s cuellosDeBotella=%d",
                testId, totalRequests, errorRate, p95Ms, p99Ms, hasViolations, bottleneckEndpoints.size());
    }
}
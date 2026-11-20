package adapter.outbound;

import core.model.LoadTestResults;
import org.springframework.stereotype.Component;

import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Adaptador de salida que almacena los reportes de pruebas de carga en memoria.
 * Usa un mapa concurrente porque las ejecuciones pueden reportar en paralelo.
 */
@Component
public class ReportStorageAdapter implements ReportStoragePort {

    private final Map<String, LoadTestResults> reportStorage = new ConcurrentHashMap<>();

    @Override
    public void storeReport(String testId, LoadTestResults results) {
        if (testId == null || results == null) {
            throw new IllegalArgumentException("Test ID and results must not be null");
        }
        reportStorage.put(testId, results);
    }

    @Override
    public Optional<LoadTestResults> retrieveReport(String testId) {
        if (testId == null) {
            throw new IllegalArgumentException("Test ID must not be null");
        }
        return Optional.ofNullable(reportStorage.get(testId));
    }

    @Override
    public void clearReports() {
        reportStorage.clear();
    }
}
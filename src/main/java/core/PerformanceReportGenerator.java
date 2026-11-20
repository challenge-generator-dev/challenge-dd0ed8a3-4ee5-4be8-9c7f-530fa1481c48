// TODO(reto): archivo stubbeado; implementa los cuerpos.
package core;

import com.fasterxml.jackson.databind.ObjectMapper;
import core.model.AnalysisReport;
import core.model.PerformanceReport;
import core.port.ReportStoragePort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.io.IOException;

// Genera y persiste el reporte de rendimiento a partir del analisis de percentiles.
@Component
@RequiredArgsConstructor
public class PerformanceReportGenerator {

    private final ReportStoragePort reportStoragePort;
    private final ObjectMapper objectMapper = new ObjectMapper();

    // TODO(reto): construir un PerformanceReport a partir de AnalysisReport (p95, p99, violaciones y cuellos de botella).
    public PerformanceReport generate(AnalysisReport reportData) {
      throw new UnsupportedOperationException("TODO(reto): generate");
    }

    // TODO(reto): serializar el reporte con objectMapper y guardarlo a traves de reportStoragePort.
    public void persist(AnalysisReport reportData) throws IOException {
      throw new UnsupportedOperationException("TODO(reto): persist");
    }
}
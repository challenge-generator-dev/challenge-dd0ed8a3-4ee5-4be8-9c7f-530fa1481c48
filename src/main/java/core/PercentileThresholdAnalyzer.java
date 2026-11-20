// TODO(reto): archivo stubbeado; implementa los cuerpos.
package core;

import core.model.AnalysisReport;
import core.model.LoadTestResults;
import core.model.PercentileThresholds;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@Component
@RequiredArgsConstructor
public class PercentileThresholdAnalyzer {

    public AnalysisReport analyze(LoadTestResults results, PercentileThresholds thresholds) {
      throw new UnsupportedOperationException("TODO(reto): analyze");
    }

    private Map<String, Double> calculatePercentile(Map<String, List<Long>> endpointLatencies, int percentile) {
      throw new UnsupportedOperationException("TODO(reto): calculatePercentile");
    }

    private Optional<String> detectBottleneck(Map<String, Double> p95Values, Map<String, Double> p99Values,
                                             PercentileThresholds thresholds) {
                                               throw new UnsupportedOperationException("TODO(reto): detectBottleneck");
                                             }
}
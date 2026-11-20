// TODO(reto): archivo stubbeado; implementa los cuerpos.
package core;

import core.model.LoadTestParameters;
import core.model.LoadTestResults;
import core.port.PerformanceTestPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.concurrent.CompletableFuture;

@Component
@RequiredArgsConstructor
public class LoadTestExecutor {
    private final PerformanceTestPort performanceTestPort;

    public CompletableFuture<LoadTestResults> execute(LoadTestParameters testParameters) {
      throw new UnsupportedOperationException("TODO(reto): execute");
    }
}
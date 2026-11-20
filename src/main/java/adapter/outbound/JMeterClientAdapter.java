// TODO(reto): archivo stubbeado; implementa los cuerpos.
package adapter.outbound;

import core.model.LoadTestParameters;
import core.model.LoadTestResults;
import core.port.PerformanceTestPort;
import lombok.RequiredArgsConstructor;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@RequiredArgsConstructor
public class JMeterClientAdapter implements PerformanceTestPort {
    private final JMeterClient jMeterClient;
    private final ExecutorService executorService = Executors.newSingleThreadExecutor();

    @Override
    public CompletableFuture<LoadTestResults> execute(LoadTestParameters testParameters) {
      throw new UnsupportedOperationException("TODO(reto): execute");
    }
}
// TODO(reto): archivo stubbeado; implementa los cuerpos.
package adapter.outbound;

import core.model.LoadTestParameters;
import org.apache.jmeter.engine.StandardJMeterEngine;
import org.apache.jmeter.reporters.ResultCollector;
import org.apache.jmeter.reporters.Summariser;
import org.apache.jmeter.save.SaveService;
import org.apache.jmeter.testelement.TestPlan;
import org.apache.jmeter.threads.ThreadGroup;
import org.apache.jmeter.util.JMeterUtils;
import org.apache.jorphan.collections.HashTree;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Map;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;

// Cliente de bajo nivel de JMeter: construye el plan de prueba, ejecuta el motor
// y entrega el resultado. La logica de agregacion de resultados vive en la pieza
// del dominio (PerformanceReportGenerator), no aqui.
public class JMeterClient {
    private final ExecutorService executorService;
    private final String jmeterHome;
    private final File tempTestPlanDir;

    public JMeterClient(ExecutorService executorService, String jmeterHome) {
        this.executorService = executorService;
        this.jmeterHome = jmeterHome;
        this.tempTestPlanDir = createTempDirectory();
        initializeJMeter();
    }

    private void initializeJMeter() {
        if (jmeterHome != null && !jmeterHome.isBlank()) {
            JMeterUtils.setJMeterHome(jmeterHome);
        }
        JMeterUtils.loadJMeterProperties(JMeterUtils.getJMeterHome() + "/bin/jmeter.properties");
        JMeterUtils.initLocale();
    }

    private File createTempDirectory() {
        try {
            File tempDir = Files.createTempDirectory("jmeter-test-").toFile();
            tempDir.deleteOnExit();
            return tempDir;
        } catch (IOException e) {
            throw new RuntimeException("No se pudo crear el directorio temporal para la prueba JMeter", e);
        }
    }

    public CompletableFuture<Map<String, Object>> executeTest(LoadTestParameters parameters) {
      throw new UnsupportedOperationException("TODO(reto): executeTest");
    }

    private HashTree buildTestPlan(LoadTestParameters parameters) {
      throw new UnsupportedOperationException("TODO(reto): buildTestPlan");
    }

    private Map<String, Object> buildExecutionSummary(String resultFile) {
        File file = new File(resultFile);
        if (!file.exists()) {
            return Map.of("error", "Archivo de resultados no encontrado");
        }
        return Map.of("resultFile", resultFile, "status", "completed");
    }

    public void shutdown() {
      throw new UnsupportedOperationException("TODO(reto): shutdown");
    }
}
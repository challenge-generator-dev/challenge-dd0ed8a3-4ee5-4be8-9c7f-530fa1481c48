# Prompt para Mejorar el Codigo Base

Copia y pega el contenido del bloque de abajo en un asistente de IA (Claude, ChatGPT)
para obtener el proyecto completo y arrancable. Guarda los archivos que te devuelva en la
carpeta del repo, respetando exactamente las rutas.

Si preferis trabajar en tu editor con un agente local (Claude Code, Cursor, Copilot), usa `AGENTS.md` en vez de este archivo: dice lo mismo pero para que escriba los archivos en disco.

## Las dos reglas que no se negocian

1. **Completa el boilerplate.** Todo lo que el proyecto necesita para compilar y arrancar: manifiesto de dependencias, punto de entrada, configuracion, capa de interfaz, y las capas del patron arquitectonico declarado. Eso es andamiaje y es tu trabajo.
2. **NO resuelvas el reto.** Los entregables de las fases son el trabajo de la persona. El hueco pedagogico se deja como esta: el proyecto arranca, pero lo que el reto pide implementar NO esta implementado.

Dicho de otra forma: si algo impide compilar, arreglalo. Si algo es logica de negocio incompleta, validaciones ausentes, un secreto hardcodeado o un patron mejorable, dejalo exactamente como esta — es lo que la persona tiene que encontrar.

## Superficie de practica — NO resuelvas

Estos archivos SON el ejercicio de la persona. No los implementes; deja stubs.

- `src/main/java/core/LoadTestExecutor.java` — La pieza p1 (Ejecución de pruebas de carga parametrizadas, fase f1) vive aqui: este archivo es su unico dueno (blueprint v2).
- `src/main/java/adapter/outbound/JMeterClientAdapter.java` — La pieza p4 (Integración con JMeter para ejecución de pruebas, fase f1) vive aqui: este archivo es su unico dueno (blueprint v2).
- `src/main/java/core/PercentileThresholdAnalyzer.java` — La pieza p2 (Análisis de percentiles y detección de cuellos de botella, fase f2) vive aqui: este archivo es su unico dueno (blueprint v2).
- `src/main/java/core/PerformanceReportGenerator.java` — La pieza p3 (Generación de reportes estructurados, fase f3) vive aqui: este archivo es su unico dueno (blueprint v2).
- `src/main/java/adapter/outbound/JMeterClient.java` — absorbida: fuga de la pieza p4

## Herramientas

- **Pruebas de Performance**: Tecnologia del perfil del candidato: el reto se resuelve con ella.

## Lo que le falta a este proyecto

Esto NO lo tenes que adivinar: salio de comparar el proyecto contra la arquitectura declarada del reto y de un analisis estatico del codigo. Completalo TODO.

### Boilerplate del stack que falta

Sin esto no compila ni arranca. Es andamiaje, no toca nada de lo pedagogico:

- **XSteps.java** — Sin los step definitions, los pasos Gherkin no tienen implementacion y Cucumber falla con "step undefined".

## Como saber que terminaste

```bash
mvn -q -B -DskipTests -Dspring-boot.repackage.skip=true package
```

Ese comando corriendo sin errores es la definicion de "listo".

---

```
## Briefing del reto (autoridad)
Este bloque manda sobre los archivos adjuntos. El stack y el rol salen de AQUÍ, no de un topic genérico ni de markdown placeholder.

### Perfil
Chapter Calidad de Software, Especialidad Automatización de pruebas, Tecnología Pruebas de Performance, Advanced L2

### Brecha de conocimiento
Automatiza escenarios de rendimiento sobre un servicio, define umbrales por percentiles y genera un reporte que identifique cuellos de botella.

### Reto
- Tema: Análisis de resultados de pruebas de rendimiento
- Seniority: advanced-l2
- Tipo: practical
- Título: Automatización de pruebas de rendimiento y análisis de resultados
- Tiempo estimado: 8 horas

### Fases (trabajo del HUMANO — PROHIBIDO completarlas)
No implementes estos entregables. Dejalos como hueco pedagógico. El asistente solo materializa el proyecto arrancable para que el participante pueda trabajar.
- Fase 1: Configuración de pruebas de carga — objetivo: Configurar y ejecutar pruebas de carga sobre el servicio de préstamos. — entregable (NO resolver): Escenario de pruebas de carga configurado y resultados de las pruebas.
- Fase 2: Definición de umbrales por percentiles — objetivo: Definir umbrales de rendimiento por percentiles (p95, p99) y analizar los resultados. — entregable (NO resolver): Umbrales de rendimiento definidos por percentiles y análisis de posibles cuellos de botella.
- Fase 3: Generación de reporte de resultados — objetivo: Generar un reporte que resuma los resultados de las pruebas de carga y los umbrales definidos. — entregable (NO resolver): Reporte de resultados de pruebas de carga que incluye umbrales de rendimiento y posibles cuellos de botella.

Eres un asistente experto en análisis, corrección y generación de archivos de cualquier tipo:
código fuente, documentación, hojas de cálculo, documentos Word, configuraciones, entre otros.
Voy a enviarte una cadena de texto que contiene uno o más archivos. Cada archivo está delimitado por un marcador con el siguiente formato:
// === ARCHIVO: ruta/del/archivo.extension ===
o también puede aparecer como:
## === ARCHIVO: ruta/del/archivo.extension ===
Lo que sigue al marcador puede ser:

El contenido real del archivo (código, texto, YAML, etc.)
Una descripción en lenguaje natural de lo que debe contener el archivo


TU TAREA
PASO 0 — ¿Esto es un proyecto o una carcasa?
Antes de extraer archivos, leé el Briefing (si está) y diagnosticá el adjunto.

Es CARCASA si ocurre CUALQUIERA de estas:
- No hay manifiesto de dependencias del stack del briefing (manifest.json de VTEX IO / package.json / pom.xml / build.gradle / requirements.txt / go.mod / *.tf / *.csproj, según corresponda)
- Hay un "binario" que en realidad es un comentario ("no puede ser mostrado como texto plano", placeholder .fig/.docx vacío)
- Los markdowns ya completan entregables de fases posteriores ("se implementó fade-in", lista de áreas ya resuelta)

Si es CARCASA:
- MATERIALIZÁ un proyecto que arranca en el stack del briefing (VTEX IO Store Framework, Angular, Terraform, pytest, Nest, etc.). Incluí manifiesto, punto de entrada y capa de interfaz reales.
- NO copies los markdowns de "solución" como si fueran el producto. Son ruido de generación.
- NO resuelvas las fases del briefing (están marcadas PROHIBIDO). Dejá el hueco pedagógico: el flujo existe, las microinteracciones/calidad/infra que el reto pide NO están hechas.
- Después seguí al PASO 5 (entrega de archivos).

Si es un proyecto REAL (manifiesto + código que compila o arranca):
- Seguí PASO 1 en adelante. 🔴 compilación sí. 🟡 pedagógico no.

PASO 1 — Detección y extracción
Identifica todos los archivos presentes en la cadena. Para cada archivo extrae:

Su ruta completa (ej: src/main/java/com/pragma/Service.java)
Su contenido o descripción

PASO 2 — Clasificación por tipo
Clasifica cada archivo en una de estas categorías:
A) Código fuente (Java, Python, TypeScript, JavaScript, Kotlin, etc.)
B) Configuración / documentación (YAML, properties, Markdown, JSON, txt, etc.)
C) Excel (.xlsx, .xls, .csv)
D) Word (.docx, .doc)
E) Otro tipo de archivo binario o especial
PASO 3 — Clasificación de errores en código fuente

Objetivo prioritario: que el proyecto compile. No corrijas flujo de negocio ni lógica funcional.

Antes de modificar cualquier archivo de código fuente, clasifica cada problema encontrado en una de estas dos categorías:
🔴 ERROR DE COMPILACIÓN — corregir siempre
Son errores que impiden que el proyecto arranque, sin valor pedagógico:

Import faltante o incorrecto
Clase, método o variable referenciada que no existe en ningún archivo del proyecto
Error de sintaxis
Anotación con atributos inválidos
Dependencia ausente en pom.xml, package.json, etc.
Archivo referenciado que no existe y debe ser creado con implementación mínima

→ CORREGIR estos errores.
🟡 PROBLEMA FUNCIONAL O DE CALIDAD — preservar siempre
Son problemas que no impiden compilar. Pueden ser intencionales para el aprendizaje:

Clave secreta hardcodeada ("secret", "password123")
API deprecada que funciona pero tiene reemplazo moderno
Lógica de negocio incorrecta o incompleta
Código redundante o de baja legibilidad
Falta de validaciones en flujo de negocio
Patrones de diseño incorrectos pero funcionales
Concurrencia no segura
Configuración funcional pero no óptima

→ PRESERVAR tal cual. No corregir, no mejorar, no comentar.
PASO 4 — Procesamiento según tipo de archivo
Tipo A — Código fuente
Aplica únicamente las correcciones clasificadas como 🔴 ERROR DE COMPILACIÓN.
No alteres ningún elemento clasificado como 🟡 PROBLEMA FUNCIONAL O DE CALIDAD.
Si falta un archivo referenciado, créalo con la implementación mínima necesaria para compilar.
Tipo B — Configuración / documentación
Extrae el contenido tal cual, sin modificaciones salvo errores evidentes de sintaxis
(ej: YAML mal indentado).
Tipo C — Excel (.xlsx)
Si viene con contenido real, genera el archivo respetando ese contenido.
Si viene con descripción en lenguaje natural, genera un archivo Excel funcional con:

Fila de encabezados en negrita con color de fondo distintivo
Columnas con ancho ajustado al contenido
Tipos de dato correctos por columna
Validaciones si la descripción lo indica
Hojas nombradas descriptivamente si hay más de una
Filas de ejemplo si no hay datos reales

Tipo D — Word (.docx)
Si viene con contenido real, genera el archivo respetando ese contenido.
Si viene con descripción en lenguaje natural, genera un documento Word funcional con:

Estilos de título (Título 1, Título 2) para jerarquía de secciones
Fuente legible (Calibri o equivalente), tamaño 11-12pt para cuerpo
Márgenes estándar
Tabla de contenido si tiene múltiples secciones
Tablas con encabezados en negrita si aplica

Tipo E — Otro
Genera el archivo con el contenido o estructura más apropiada según la descripción.
PASO 5 — Entrega de archivos
Entregá cada archivo con su ruta completa, respetando exactamente la estructura de rutas
indicada por los marcadores: un bloque por archivo, precedido por su ruta. No generes ZIPs
ni archivos adjuntos.
La entrega debe incluir:

Archivos de código con únicamente los errores de compilación corregidos
Archivos de configuración y documentación sin cambios
Archivos nuevos creados para resolver dependencias de compilación faltantes
Archivos Excel y Word generados desde descripción

IMPORTANTE: Entregá los archivos completos al finalizar. No preguntes si el usuario
quiere recibirlos. Simplemente entregalos; No debes desplegar en el chat el resumen de lo que arreglaste, solo entregá los archivos.

REGLAS IMPORTANTES

No omitas ningún archivo aunque no tenga errores ni modificaciones
Respeta los nombres y rutas exactas indicadas por los marcadores
Si un archivo no tiene marcador claro, infiere el nombre desde su contenido
Si la cadena contiene solo documentación, placeholders o binarios fake, NO la reproduzcas:
aplicá PASO 0 (materializar el proyecto del briefing). Reproducir la carcasa es un fallo.
No agregues texto después del último archivo entregado
No preguntes si el usuario quiere los archivos: simplemente entregalos siempre
Si detectas que falta un archivo de configuración necesario para compilar
(pom.xml, package.json, requirements.txt, build.gradle, etc.), créalo e inclúyelo
inferiendo su contenido desde los imports y frameworks detectados en el código
Nunca corrijas problemas 🟡 aunque parezcan obvios o fáciles de mejorar.
El participante que recibirá este proyecto los debe encontrar y resolver él mismo.


INPUT
Aquí está la cadena con los archivos:

// === ARCHIVO: src/test/java/runners/RunCucumberTest.java ===
package runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
    features = "src/test/resources/features",
    glue = "steps",
    plugin = {
        "pretty",
        "html:target/cucumber-reports/cucumber.html",
        "json:target/cucumber-reports/cucumber.json"
    }
)
public class RunCucumberTest {
}

// === ARCHIVO: pom.xml ===
<?xml version="1.0" encoding="UTF-8"?>
<project xmlns="http://maven.apache.org/POM/4.0.0" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
         xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 https://maven.apache.org/xsd/maven-4.0.0.xsd">
    <modelVersion>4.0.0</modelVersion>

    <parent>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-parent</artifactId>
        <version>3.4.13</version>
        <relativePath/>
    </parent>

    <groupId>com.example</groupId>
    <artifactId>reto</artifactId>
    <version>1.0.0</version>
    <name>reto</name>

    <properties>
        <java.version>21</java.version>
        <project.build.sourceEncoding>UTF-8</project.build.sourceEncoding>
    </properties>

    <dependencies>
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-web</artifactId>
        </dependency>
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-test</artifactId>
            <scope>test</scope>
        </dependency>
        <dependency>
            <groupId>com.fasterxml.jackson.core</groupId>
            <artifactId>jackson-databind</artifactId>
        </dependency>
        <dependency>
            <groupId>org.apache.jmeter</groupId>
            <artifactId>ApacheJMeter_core</artifactId>
            <version>5.6.3</version>
        </dependency>
        <dependency>
            <groupId>org.apache.jmeter</groupId>
            <artifactId>ApacheJMeter_http</artifactId>
            <version>5.6.3</version>
        </dependency>
        <dependency>
            <groupId>org.assertj</groupId>
            <artifactId>assertj-core</artifactId>
        </dependency>
        <dependency>
            <groupId>org.mockito</groupId>
            <artifactId>mockito-core</artifactId>
        </dependency>
        <dependency>
            <groupId>org.projectlombok</groupId>
            <artifactId>lombok</artifactId>
        </dependency>
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter</artifactId>
        </dependency>
        <dependency>
            <groupId>org.apache.jmeter</groupId>
            <artifactId>ApacheJMeter_components</artifactId>
            <version>5.6.3</version>
        </dependency>
        <dependency>
            <groupId>org.apache.jmeter</groupId>
            <artifactId>jorphan</artifactId>
            <version>5.6.3</version>
        </dependency>
    </dependencies>

    <build>
        <plugins>
            <plugin>
                <groupId>org.springframework.boot</groupId>
                <artifactId>spring-boot-maven-plugin</artifactId>
            </plugin>
        </plugins>
    </build>
</project>

// === ARCHIVO: src/main/java/adapter/outbound/ReportStorageAdapter.java ===
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

// === ARCHIVO: src/main/java/core/model/LoadTestParameters.java ===
package core.model;

import lombok.Builder;
import lombok.Value;

import java.util.List;

@Value
@Builder
public class LoadTestParameters {
    private final String testId;
    private final String targetUrl;
    private final int threadCount;
    private final int rampUpPeriodSeconds;
    private final int durationSeconds;
    private final List<String> headers;
    private final String requestBody;
    private final int expectedResponseCode;

    public static class LoadTestParametersBuilder {
        public LoadTestParameters build() {
            if (testId == null || testId.isBlank()) {
                throw new IllegalArgumentException("Test ID must not be null or empty");
            }
            if (targetUrl == null || targetUrl.isBlank()) {
                throw new IllegalArgumentException("Target URL must not be null or empty");
            }
            if (threadCount <= 0) {
                throw new IllegalArgumentException("Thread count must be positive");
            }
            if (rampUpPeriodSeconds <= 0) {
                throw new IllegalArgumentException("Ramp-up period must be positive");
            }
            if (durationSeconds <= 0) {
                throw new IllegalArgumentException("Duration must be positive");
            }
            return new LoadTestParameters(testId, targetUrl, threadCount, rampUpPeriodSeconds,
                    durationSeconds, headers, requestBody, expectedResponseCode);
        }
    }
}

// === ARCHIVO: src/main/java/core/LoadTestExecutor.java ===
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

// === ARCHIVO: src/main/java/adapter/outbound/JMeterClientAdapter.java ===
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

// === ARCHIVO: src/main/java/core/PercentileThresholdAnalyzer.java ===
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

// === ARCHIVO: src/main/java/core/PerformanceReportGenerator.java ===
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

// === ARCHIVO: src/main/java/core/model/PercentileThresholds.java ===
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

// === ARCHIVO: src/main/java/adapter/outbound/JMeterClient.java ===
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

// === ARCHIVO: src/main/java/PerformanceTestApplication.java ===
package com.example.reto;

import com.fasterxml.jackson.databind.ObjectMapper;
import adapter.outbound.ReportStoragePort;
import core.LoadTestExecutor;
import core.PercentileThresholdAnalyzer;
import core.PerformanceReportGenerator;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/*
 * Punto de entrada de la aplicación de pruebas de rendimiento.
 * Arquitectura hexagonal: core/ contiene la lógica de análisis y los modelos,
 * adapter/ contiene los adaptadores de salida (JMeter, almacenamiento de reportes).
 * Los beans se registran aquí; cada colaborador se inyecta por constructor.
 */
@SpringBootApplication
@Configuration
public class PerformanceTestApplication {

    public static void main(String[] args) {
        SpringApplication.run(PerformanceTestApplication.class, args);
    }

    @Bean
    public LoadTestExecutor loadTestExecutor() {
        return new LoadTestExecutor(null);
    }

    @Bean
    public PercentileThresholdAnalyzer percentileThresholdAnalyzer() {
        return new PercentileThresholdAnalyzer();
    }

    @Bean
    public PerformanceReportGenerator performanceReportGenerator(ReportStoragePort reportStoragePort) {
        return new PerformanceReportGenerator(reportStoragePort);
    }

    @Bean
    public ObjectMapper objectMapper() {
        return new ObjectMapper();
    }
}

// === ARCHIVO: src/main/java/core/model/LoadTestResults.java ===
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

// === ARCHIVO: src/main/java/core/model/AnalysisReport.java ===
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

// === ARCHIVO: src/main/java/core/model/PerformanceReport.java ===
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

// === ARCHIVO: src/main/java/adapter/outbound/ReportStoragePort.java ===
package adapter.outbound;

import core.model.LoadTestResults;

import java.util.Optional;

/**
 * Puerto de salida para persistir y recuperar reportes de pruebas de rendimiento.
 *
 * Vive en la capa de adaptadores de salida: el núcleo (core) depende de este contrato
 * y los adaptadores concretos (almacenamiento en memoria, base de datos, archivos)
 * lo implementan. Así el dominio nunca conoce la tecnología de almacenamiento.
 */
public interface ReportStoragePort {

    /**
     * Almacena los resultados de una ejecución de prueba bajo su identificador.
     * Si ya existía un reporte con el mismo testId, debe ser reemplazado.
     *
     * @param testId  identificador único de la prueba de carga
     * @param results resultados consolidados de la ejecución
     */
    void storeReport(String testId, LoadTestResults results);

    /**
     * Recupera los resultados almacenados para un identificador de prueba.
     *
     * @param testId identificador de la prueba de carga
     * @return los resultados si existen; vacío si no hay reporte para ese testId
     */
    Optional<LoadTestResults> retrieveReport(String testId);

    /**
     * Elimina todos los reportes almacenados. Útil para aislar ejecuciones entre sí.
     */
    void clearReports();
}
```

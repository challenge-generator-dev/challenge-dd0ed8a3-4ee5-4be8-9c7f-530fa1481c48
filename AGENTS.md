# AGENTS.md

Instrucciones para el agente de IA que abra este repositorio (Claude Code, Cursor, Codex, Copilot, Gemini). Se cargan solas: no hay que pegar nada en ningun chat.

## Que es este repositorio

Es el codigo base de un reto de aprendizaje de Pragma: **Automatización de pruebas de rendimiento y análisis de resultados**.

| | |
|---|---|
| Tema | Análisis de resultados de pruebas de rendimiento |
| Nivel | advanced-l2 |
| Chapter | Calidad de Software |
| Especialidad | Automatizador |
| Stack | Java / Spring Boot 3.3 |
| Patron arquitectonico | hexagonal/clean con capas de testing especializadas |
| Tiempo estimado | 8 horas |

## Herramientas

- **Pruebas de Performance**: Tecnologia del perfil del candidato: el reto se resuelve con ella.

## Receta del stack

Esqueleto obligatorio:

- `pom.xml en la raiz con el runner y el plugin de reportes`
- `src/test/resources/features con los .feature en Gherkin`
- `src/test/java/.../runners con el runner`
- `src/test/java/.../pages o /tasks con Page Objects o Screenplay`
- `src/test/java/.../steps con los step definitions`
- `serenity.conf o config del entorno`

Trampas conocidas:

- Sin parent POM que gestione versiones, TODA dependencia lleva su `<version>` completa de tres segmentos.
- El groupId de Serenity es `net.serenity-bdd`, NO `org.serenity-bdd`. Con el groupId equivocado el artefacto no existe y el build muere resolviendo dependencias.
- Coordenadas exactas de lo mas usado: Selenium `org.seleniumhq.selenium:selenium-java`, Rest Assured `io.rest-assured:rest-assured`, Karate `com.intuit.karate:karate-junit5`, Cucumber `io.cucumber:cucumber-java`.
- JUnit 5 se declara con `junit-jupiter` (agregador) y necesita `maven-surefire-plugin` reciente para ejecutarse.
- Serenity y Cucumber tienen que ser de lineas compatibles entre si; mezclarlas rompe el runner.

Dependencias:

- org.springframework.boot:spring-boot-starter-web
- org.springframework.boot:spring-boot-starter-test
- com.fasterxml.jackson.core:jackson-databind
- org.apache.jmeter:ApacheJMeter_core 5.6.3
- org.apache.jmeter:ApacheJMeter_http 5.6.3
- org.assertj:assertj-core
- org.mockito:mockito-core
- org.projectlombok:lombok
- org.springframework.boot:spring-boot-starter
- org.apache.jmeter:ApacheJMeter_components 5.6.3
- org.apache.jmeter:jorphan 5.6.3

## Tu tarea

Dejar este proyecto en estado **verificable**: que el comando de verificacion corra sin errores. Escribi los archivos en disco, en este repositorio. No generes ZIPs ni archivos adjuntos.

En orden:

1. Corre `mvn -q -B -DskipTests -Dspring-boot.repackage.skip=true package` y mira que falla.
2. Completa lo que falte de la lista de abajo: manifiesto de dependencias, punto de entrada, capa de interfaz y las capas del patron declarado.
3. Arregla SOLO los errores que impiden compilar o arrancar.
4. Volve a correr `mvn -q -B -DskipTests -Dspring-boot.repackage.skip=true package` hasta que pase.
5. Pará ahí.

## Regla dura: las fases son trabajo del humano

**PROHIBIDO implementar los entregables de las fases.** El valor del reto esta en que la persona los resuelva. Tu trabajo es que tenga un proyecto que arranca; el hueco pedagogico se queda como esta.

No resuelvas nada de esto:

- **Fase 1 — Configuración de pruebas de carga**: Escenario de pruebas de carga configurado y resultados de las pruebas.
- **Fase 2 — Definición de umbrales por percentiles**: Umbrales de rendimiento definidos por percentiles y análisis de posibles cuellos de botella.
- **Fase 3 — Generación de reporte de resultados**: Reporte de resultados de pruebas de carga que incluye umbrales de rendimiento y posibles cuellos de botella.

Distincion operativa:

- **Arreglar** (si): import faltante, tipo que no existe, dependencia sin declarar, error de sintaxis, archivo referenciado que no existe.
- **No tocar** (no): logica de negocio incompleta, validaciones ausentes, secretos hardcodeados, APIs deprecadas que funcionan, concurrencia insegura, patrones mejorables. Eso es lo que la persona tiene que encontrar.

## Superficie de practica (NO completes)

Estos archivos SON el ejercicio de la persona. No los implementes; deja stubs. No toques la logica que el reto pide completar.

- [ ] `src/main/java/core/LoadTestExecutor.java` — La pieza p1 (Ejecución de pruebas de carga parametrizadas, fase f1) vive aqui: este archivo es su unico dueno (blueprint v2).
- [ ] `src/main/java/adapter/outbound/JMeterClientAdapter.java` — La pieza p4 (Integración con JMeter para ejecución de pruebas, fase f1) vive aqui: este archivo es su unico dueno (blueprint v2).
- [ ] `src/main/java/core/PercentileThresholdAnalyzer.java` — La pieza p2 (Análisis de percentiles y detección de cuellos de botella, fase f2) vive aqui: este archivo es su unico dueno (blueprint v2).
- [ ] `src/main/java/core/PerformanceReportGenerator.java` — La pieza p3 (Generación de reportes estructurados, fase f3) vive aqui: este archivo es su unico dueno (blueprint v2).
- [ ] `src/main/java/adapter/outbound/JMeterClient.java` — absorbida: fuga de la pieza p4

## Mapa de fases

La **Fase 0** es clonar el repositorio, instalar dependencias y correr las pruebas de aceptacion: todas fallan porque la logica de cada pieza esta pendiente.

| Fase | Pieza (skill) | Archivo:simbolo | Criterios | Prueba | Comando |
|------|---------------|-----------------|-----------|--------|---------|
| f1 — Configuración de pruebas de carga | Ejecución de pruebas de carga parametrizadas | `src/main/java/core/LoadTestExecutor.java:LoadTestExecutor` | El escenario de pruebas de carga se ejecuta con parámetros configurables (usuarios concurrentes, duración).; Los resultados de la prueba se almacenan en un formato estructurado para análisis posterior. | — | — |
| f1 — Configuración de pruebas de carga | Integración con JMeter para ejecución de pruebas | `src/main/java/adapter/outbound/JMeterClientAdapter.java:JMeterClientAdapter` | El escenario de pruebas de carga se ejecuta con parámetros configurables (usuarios concurrentes, duración).; Los resultados de la prueba se almacenan en un formato estructurado para análisis posterior. | — | — |
| f2 — Definición de umbrales por percentiles | Análisis de percentiles y detección de cuellos de botella | `src/main/java/core/PercentileThresholdAnalyzer.java:PercentileThresholdAnalyzer` | Los umbrales para p95 y p99 están definidos y se aplican a los resultados de las pruebas.; Se identifica correctamente si algún percentil supera su umbral.; Se detecta el endpoint o operación con peor rendimiento (cuello de botella).; Se maneja el caso donde los resultados de la prueba están incompletos o son inválidos. | — | — |
| f3 — Generación de reporte de resultados | Generación de reportes estructurados | `src/main/java/core/PerformanceReportGenerator.java:PerformanceReportGenerator` | El reporte incluye los resultados de las pruebas, umbrales aplicados y percentiles calculados.; El reporte identifica claramente los cuellos de botella detectados.; El reporte maneja casos donde no hay datos suficientes para generar conclusiones.; El reporte se genera en un formato legible (ej. JSON, HTML) y es persistido. | — | — |

## Pruebas de aceptacion y ubicacion de la logica

Las pruebas de aceptacion (columna "Prueba" de la tabla) son de **solo lectura**: definen que significa "listo". No las edites, no las borres y no les agregues `skip`; lo que se resuelve es el codigo de cada pieza.

La logica de cada pieza va en su archivo; no la muevas a otro.

## Restricciones del pedido

| Restriccion | Donde se cumple | Estado |
|-------------|-----------------|--------|
| Ejecuta pruebas de carga pero no sabe interpretar percentiles ni identificar el cuello de botella | `src/test/java/acceptance/f2/AcceptanceTest.java` > should_identify_bottleneck_when_p99_exceeds_threshold | Restriccion no verificada en `src/test/java/acceptance/f2/AcceptanceTest.java` > should_identify_bottleneck_when_p99_exceeds_threshold |

## Lo que falta y tenes que completar

### 1. Boilerplate del stack (1)

Sin esto el proyecto no compila ni arranca. **Es tu trabajo crearlo**, y no toca nada de lo pedagogico: es andamiaje del stack.

- [ ] **XSteps.java** — Sin los step definitions, los pasos Gherkin no tienen implementacion y Cucumber falla con "step undefined".

### Presentes (15)

- `src/test/java/runners/RunCucumberTest.java`
- `pom.xml`
- `src/main/java/adapter/outbound/ReportStorageAdapter.java`
- `src/main/java/core/model/LoadTestParameters.java`
- `src/main/java/core/LoadTestExecutor.java`
- `src/main/java/adapter/outbound/JMeterClientAdapter.java`
- `src/main/java/core/PercentileThresholdAnalyzer.java`
- `src/main/java/core/PerformanceReportGenerator.java`
- `src/main/java/core/model/PercentileThresholds.java`
- `src/main/java/adapter/outbound/JMeterClient.java`
- `src/main/java/PerformanceTestApplication.java`
- `src/main/java/core/model/LoadTestResults.java`
- `src/main/java/core/model/AnalysisReport.java`
- `src/main/java/core/model/PerformanceReport.java`
- `src/main/java/adapter/outbound/ReportStoragePort.java`

### Capas del patron declarado

Son las capas que la propuesta arquitectonica plantea, marcadas segun existan hoy en el repo. Orientan donde poner el codigo nuevo; no son una condicion para compilar.

- `src/main/java/com/pragma/performance/core` (ausente)
- `src/main/java/com/pragma/performance/core/model` (ausente)
- `src/main/java/com/pragma/performance/core/port` (ausente)
- `src/main/java/com/pragma/performance/adapter/outbound` (ausente)
- `src/test/java/com/pragma/performance/core` (ausente)
- `src/test/resources` (ausente)

## Verificacion

```bash
mvn -q -B -DskipTests -Dspring-boot.repackage.skip=true package
```

El comando tiene que pasar SIN implementar los archivos de la superficie de practica: solo andamiaje.

Ese comando pasando es la definicion de "terminado" para vos.

## Convenciones que tenes que respetar

- Un solo ecosistema: no declares librerias de otro lenguaje ni mezcles gestores de paquetes.
- Toda libreria que uses tiene que estar declarada en el manifiesto de dependencias.
- Todo import declarado tiene que usarse; todo tipo usado tiene que existir o venir de una dependencia declarada.
- El patron es **hexagonal/clean con capas de testing especializadas**: los contratos (interfaces, puertos) los define la capa interna y los implementa la externa, nunca al revés.
- Los archivos que crees llevan implementacion real, no stubs: sin `TODO`, sin cuerpos vacios, sin `// getters y setters`.

## Contexto del candidato

Sirve para calibrar el nivel del codigo, no para resolver las fases.

- Perfil: Chapter Calidad de Software, Especialidad Automatización de pruebas, Tecnología Pruebas de Performance, Advanced L2
- Brecha que el reto ataca: Automatiza escenarios de rendimiento sobre un servicio, define umbrales por percentiles y genera un reporte que identifique cuellos de botella.

---

*Generado por Challenge Generator — Pragma. `README.md` tiene el enunciado completo del reto para la persona. `PROMPT_MEJORA.md` es la variante para pegar en un chat, si se prefiere ese flujo.*

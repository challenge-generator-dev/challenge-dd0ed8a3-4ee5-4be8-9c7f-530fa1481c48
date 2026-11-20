# Automatización de pruebas de rendimiento y análisis de resultados

El servicio de préstamos de un banco necesita ser evaluado bajo carga para asegurar su rendimiento. Debes automatizar escenarios de rendimiento, definir umbrales por percentiles (p95, p99) y generar un reporte que identifique posibles cuellos de botella.

## Informacion General

| Campo | Valor |
|-------|-------|
| **Tema** | Análisis de resultados de pruebas de rendimiento |
| **Nivel** | advanced-l2 |
| **Tipo** | practical |
| **Tiempo estimado** | 8 horas |

## Stack

- **Lenguaje:** Java
- **Framework:** Spring Boot 3.3
- **Version:** Java 21

## Fases del Reto

### Fase 0: Configuración del Proyecto

**Objetivo:** Tener el proyecto base del reto funcionando en tu máquina: clonar el repositorio, instalar las herramientas y verificar que compila y arranca antes de empezar a practicar.

**Tiempo estimado:** 15-30 minutos

**Instrucciones:**

- Instala las herramientas para ejecutar el proyecto: JDK 17+ y Maven 3.9+.
- Clona el repositorio del reto (el enlace viene en la entrega del reto y en la sección "Repositorio del Proyecto" del PDF) y ábrelo en tu IDE.
- Instala las dependencias y compila ejecutando `mvn -q -B -DskipTests -Dspring-boot.repackage.skip=true package` en la raíz del repositorio.
- Confirma que el comando termina sin errores: el proyecto arranca y sus pruebas corren.
- Ubica los archivos de práctica: son los que contienen `TODO(reto)` (búscalos en el repositorio). Lee el README.md y el AGENTS.md antes de empezar.

**Entregable:** El proyecto compila/arranca sin errores con `mvn -q -B -DskipTests -Dspring-boot.repackage.skip=true package`.

<details>
<summary>Pistas de conocimiento</summary>

- Los archivos con `TODO(reto)` son el ejercicio: el resto del repositorio ya está resuelto y no hace falta tocarlo.
- Si el comando de verificación falla, revisa la versión de las herramientas instaladas antes de modificar código.
- AGENTS.md describe el reto, el comando de verificación y las reglas del repositorio.

</details>

### Fase 1: Configuración de pruebas de carga

**Objetivo:** Configurar y ejecutar pruebas de carga sobre el servicio de préstamos.

**Tiempo estimado:** 2 horas

**Instrucciones:**

- Identifica los endpoints del servicio de préstamos que deben ser evaluados.
- Configura un escenario de pruebas de carga que simule un volumen de solicitudes de préstamos típico.
- Ejecuta las pruebas y recopila los resultados.

**Entregable:** Escenario de pruebas de carga configurado y resultados de las pruebas.

<details>
<summary>Pistas de conocimiento</summary>

- Considera el uso de herramientas de pruebas de carga para automatizar el proceso.
- Asegúrate de que los resultados incluyan métricas relevantes como tiempo de respuesta y tasa de éxito.

</details>

### Fase 2: Definición de umbrales por percentiles

**Objetivo:** Definir umbrales de rendimiento por percentiles (p95, p99) y analizar los resultados.

**Tiempo estimado:** 3 horas

**Instrucciones:**

- Analiza los resultados de las pruebas de carga y define umbrales de rendimiento por percentiles (p95, p99).
- Identifica posibles cuellos de botella en el servicio de préstamos basándote en los percentiles definidos.

**Entregable:** Umbrales de rendimiento definidos por percentiles y análisis de posibles cuellos de botella.

<details>
<summary>Pistas de conocimiento</summary>

- Revisa la documentación de las herramientas de pruebas de carga para entender cómo interpretar los resultados por percentiles.
- Considera el impacto de los percentiles en la experiencia del usuario y la estabilidad del servicio.

</details>

### Fase 3: Generación de reporte de resultados

**Objetivo:** Generar un reporte que resuma los resultados de las pruebas de carga y los umbrales definidos.

**Tiempo estimado:** 3 horas

**Instrucciones:**

- Crea un reporte que incluya los resultados de las pruebas de carga, los umbrales de rendimiento definidos y los posibles cuellos de botella identificados.
- Asegúrate de que el reporte sea claro y conciso, y que incluya recomendaciones para mejorar el rendimiento del servicio de préstamos.

**Entregable:** Reporte de resultados de pruebas de carga que incluye umbrales de rendimiento y posibles cuellos de botella.

<details>
<summary>Pistas de conocimiento</summary>

- Utiliza herramientas de generación de reportes para crear un documento profesional.
- Considera incluir gráficos y tablas para visualizar los resultados de manera efectiva.

</details>

## Dimensiones Evaluadas

- **queEs**: ¿Qué son las pruebas de carga y por qué son importantes en el contexto del servicio de préstamos?
- **paraQueSirve**: ¿Para qué sirven los percentiles en el análisis de resultados de pruebas de carga?
- **comoSeUsa**: ¿Cómo se utilizan las herramientas de pruebas de carga para configurar y ejecutar escenarios de rendimiento?
- **erroresComunes**: ¿Cuáles son los errores comunes al interpretar los resultados de pruebas de carga y cómo se pueden evitar?
- **queDecisionesImplica**: ¿Qué decisiones implica la generación de un reporte de resultados de pruebas de carga y cómo se pueden justificar?

## Criterios de Evaluacion

- Configuración y ejecución de pruebas de carga sobre el servicio de préstamos.
- Definición de umbrales de rendimiento por percentiles (p95, p99).
- Identificación de posibles cuellos de botella en el servicio de préstamos.
- Generación de un reporte de resultados de pruebas de carga que incluya umbrales de rendimiento y posibles cuellos de botella.

## Mapa de fases

La **Fase 0** es clonar el repositorio, instalar dependencias y correr las pruebas de aceptacion: todas fallan porque la logica de cada pieza esta pendiente.

| Fase | Pieza (skill) | Archivo:simbolo | Criterios | Prueba | Comando |
|------|---------------|-----------------|-----------|--------|---------|
| f1 — Configuración de pruebas de carga | Ejecución de pruebas de carga parametrizadas | `src/main/java/core/LoadTestExecutor.java:LoadTestExecutor` | El escenario de pruebas de carga se ejecuta con parámetros configurables (usuarios concurrentes, duración).; Los resultados de la prueba se almacenan en un formato estructurado para análisis posterior. | — | — |
| f1 — Configuración de pruebas de carga | Integración con JMeter para ejecución de pruebas | `src/main/java/adapter/outbound/JMeterClientAdapter.java:JMeterClientAdapter` | El escenario de pruebas de carga se ejecuta con parámetros configurables (usuarios concurrentes, duración).; Los resultados de la prueba se almacenan en un formato estructurado para análisis posterior. | — | — |
| f2 — Definición de umbrales por percentiles | Análisis de percentiles y detección de cuellos de botella | `src/main/java/core/PercentileThresholdAnalyzer.java:PercentileThresholdAnalyzer` | Los umbrales para p95 y p99 están definidos y se aplican a los resultados de las pruebas.; Se identifica correctamente si algún percentil supera su umbral.; Se detecta el endpoint o operación con peor rendimiento (cuello de botella).; Se maneja el caso donde los resultados de la prueba están incompletos o son inválidos. | — | — |
| f3 — Generación de reporte de resultados | Generación de reportes estructurados | `src/main/java/core/PerformanceReportGenerator.java:PerformanceReportGenerator` | El reporte incluye los resultados de las pruebas, umbrales aplicados y percentiles calculados.; El reporte identifica claramente los cuellos de botella detectados.; El reporte maneja casos donde no hay datos suficientes para generar conclusiones.; El reporte se genera en un formato legible (ej. JSON, HTML) y es persistido. | — | — |

## Pruebas de aceptacion

Las pruebas de aceptacion (columna "Prueba" de la tabla) son de **solo lectura**: definen que significa "listo". No las edites, no las borres y no les agregues `skip`; lo que se resuelve es el codigo de cada pieza.

## Restricciones del pedido

| Restriccion | Donde se cumple | Estado |
|-------------|-----------------|--------|
| Ejecuta pruebas de carga pero no sabe interpretar percentiles ni identificar el cuello de botella | `src/test/java/acceptance/f2/AcceptanceTest.java` > should_identify_bottleneck_when_p99_exceeds_threshold | Restriccion no verificada en `src/test/java/acceptance/f2/AcceptanceTest.java` > should_identify_bottleneck_when_p99_exceeds_threshold |

## Herramientas

- **Pruebas de Performance**: Tecnologia del perfil del candidato: el reto se resuelve con ella.

## Verificacion

El proyecto esta listo para trabajar cuando este comando corre sin errores:

```bash
mvn -q -B -DskipTests -Dspring-boot.repackage.skip=true package
```

---

*Reto generado automaticamente por Challenge Generator - Pragma*

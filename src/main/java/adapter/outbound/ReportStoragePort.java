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
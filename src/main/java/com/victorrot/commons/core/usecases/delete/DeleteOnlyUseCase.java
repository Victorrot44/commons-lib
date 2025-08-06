package com.victorrot.commons.core.usecases.delete;

/**
 * Caso de uso genérico para operaciones de eliminación de entidades.
 *
 * <p>Esta interfaz combina las operaciones de eliminación individual definidas 
 * en {@link DeleteUseCase} y las operaciones de eliminación en lote definidas 
 * en {@link BatchDeleteUseCase}. Se utiliza típicamente en arquitecturas limpias 
 * o hexagonales para operaciones de borrado, sin incluir lectura o persistencia.</p>
 * 
 * @author Victor Manuel Rodriguez Ramirez
 * @param <ID> el tipo del identificador único de las entidades a eliminar
 *
 * @see DeleteUseCase
 * @see BatchDeleteUseCase
 * @see ServiceException
 */
public interface DeleteOnlyUseCase<ID> extends BatchDeleteUseCase<ID>, DeleteUseCase<ID> {
}

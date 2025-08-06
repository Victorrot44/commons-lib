package com.victorrot.commons.core.usecases.find;

/**
 * Caso de uso genérico de solo lectura para entidades.
 *
 * <p>Esta interfaz combina las operaciones de búsqueda individual definidas en 
 * {@link FindUseCase} y las operaciones de búsqueda en lote definidas en 
 * {@link BatchFindUseCase}. Se utiliza típicamente en arquitecturas limpias o 
 * hexagonales como puerto de entrada (Use Case) para consultas sin operaciones 
 * de escritura.</p>
 * 
 * @author Victor Manuel Rodriguez Ramirez
 * @param <E>   el tipo de la entidad.
 * @param <ID>  el tipo del identificador único de la entidad.
 * 
 * @see FindUseCase
 * @see BatchFindUseCase
 * @see ServiceException
 */
public interface ReadOnlyUseCase<E, ID> extends FindUseCase<E, ID>, BatchFindUseCase<E> {
}

package com.victorrot.commons.core.usecases.persist;

/**
 * Caso de uso genérico para operaciones de persistencia de entidades.
 *
 * <p>Esta interfaz combina las operaciones de creación o guardado de una única
 * entidad definidas en {@link PersistUseCase} y las operaciones de persistencia
 * en lote definidas en {@link BatchPersistUseCase}. Se utiliza típicamente en
 * arquitecturas limpias o hexagonales para operaciones de escritura sin incluir 
 * lectura o eliminación.</p>
 *
 * @author Victor Manuel Rodriguez Ramirez 
 * @param <E>  el tipo de la entidad a persistir
 * @param <ID> el tipo del identificador único de la entidad
 *
 * @see PersistUseCase
 * @see BatchPersistUseCase
 * @see ServiceException
 */
public interface PersistenceOnlyUseCase<E, ID> extends PersistUseCase<E, ID>, BatchPersistUseCase<E, ID> {
}

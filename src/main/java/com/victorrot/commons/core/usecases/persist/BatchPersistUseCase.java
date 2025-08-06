package com.victorrot.commons.core.usecases.persist;

import com.victorrot.commons.exceptions.ServiceException;
import java.util.List;

/**
 * Caso de uso genérico para la creación o persistencia en lote de entidades.
 *
 * <p>Esta interfaz define un contrato para crear o guardar múltiples entidades 
 * de manera simultánea. Se utiliza típicamente en arquitecturas limpias o 
 * hexagonales, delegando la lógica de persistencia a los adaptadores 
 * correspondientes.</p>
 * 
 * @author Victor Manuel Rodriguez Ramirez 
 * @param <E>  el tipo de la entidad a persistir
 * @param <ID> el tipo del identificador único de la entidad
 * 
 * @see ServiceException
 */
public interface BatchPersistUseCase<E, ID> {
    
    /**
     * Crea o guarda todas las entidades proporcionadas.
     *
     * @param entities un iterable con las entidades que se deben crear o guardar.
     * @return una lista con las entidades persistidas (incluyendo cualquier cambio 
     *         generado por la capa de persistencia, como IDs).
     * @throws IllegalArgumentException si {@code entities} es {@code null} o contiene elementos {@code null}.
     * @throws ServiceException si ocurre un error durante la persistencia.
     */
    List<E> createAll(Iterable<E> entities);
    
}

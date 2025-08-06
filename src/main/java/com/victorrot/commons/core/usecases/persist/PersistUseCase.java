package com.victorrot.commons.core.usecases.persist;

import com.victorrot.commons.exceptions.ServiceException;

/**
 * Caso de uso genérico para la creación o persistencia de una entidad.
 *
 * <p>Esta interfaz define un contrato para crear o guardar una única entidad.
 * Se utiliza típicamente en arquitecturas limpias o hexagonales como puerto de
 * entrada (Use Case), delegando la lógica de persistencia a los adaptadores
 * correspondientes.</p>
 * 
 * @author Victor Manuel Rodriguez Ramirez
 * @param <E>  el tipo de la entidad a persistir
 * @param <ID> el tipo del identificador único de la entidad
 *
 * @see ServiceException
 */
public interface PersistUseCase<E, ID> {
    
    /**
     * Crea o guarda la entidad proporcionada.
     *
     * @param entity la entidad que se debe crear o guardar.
     * @return la entidad persistida (incluyendo cualquier cambio generado por la 
     *         capa de persistencia, como el ID).
     * @throws IllegalArgumentException si {@code entity} es {@code null}.
     * @throws ServiceException si ocurre un error durante la persistencia.
     */
    E create(E entity);

}

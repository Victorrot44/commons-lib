package com.victorrot.commons.core.usecases.delete;

import com.victorrot.commons.exceptions.ServiceException;

/**
 * Caso de uso genérico para la eliminación en lote de entidades.
 *
 * <p>Esta interfaz define un contrato para eliminar múltiples entidades a partir 
 * de sus identificadores. Se utiliza típicamente en arquitecturas limpias o 
 * hexagonales como puerto de entrada (Use Case), delegando la lógica de persistencia 
 * a los adaptadores correspondientes.</p>
 *
 * @param <ID> el tipo del identificador único de las entidades a eliminar
 *
 * @see ServiceException
 * 
 * @author Victor Manuel Rodriguez Ramirez <victorrot44@gmail.com>
 * 
 * @version 1.0.0 - New use case
 */
public interface BatchDeleteUseCase<ID> {

    /**
     * Elimina todas las entidades correspondientes a los identificadores proporcionados.
     *
     * @param ids un iterable de identificadores de las entidades que se deben eliminar
     * @throws IllegalArgumentException si {@code ids} es {@code null} o contiene elementos {@code null}
     * @throws ServiceException si la eliminación no puede completarse debido a reglas de negocio
     */
    void deleteAll(Iterable<ID> ids);
    
}



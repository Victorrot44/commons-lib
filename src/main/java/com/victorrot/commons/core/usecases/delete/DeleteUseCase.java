package com.victorrot.commons.core.usecases.delete;

import com.victorrot.commons.exceptions.ServiceException;

/**
 * Caso de uso genérico para la eliminación de una entidad por su identificador.
 *
 * <p>Esta interfaz define un contrato para eliminar una única entidad a partir 
 * de su identificador. Se utiliza típicamente en arquitecturas limpias o 
 * hexagonales como puerto de entrada (Use Case), delegando la lógica de persistencia 
 * a los adaptadores correspondientes.</p>
 *
 * @param <ID> el tipo del identificador único de la entidad a eliminar
 *
 * @see ServiceException
 * 
 * @author Victor Manuel Rodriguez Ramirez <victorrot44@gmail.com>
 * 
 * @version 1.0.0 - New use case
 */
public interface DeleteUseCase<ID> {

    /**
     * Elimina la entidad correspondiente al identificador proporcionado.
     *
     * @param id el identificador de la entidad que se debe eliminar
     * @throws IllegalArgumentException si {@code id} es {@code null}
     * @throws ServiceException si la eliminación no puede completarse debido a reglas de negocio
     */
    void delete(ID id);
}

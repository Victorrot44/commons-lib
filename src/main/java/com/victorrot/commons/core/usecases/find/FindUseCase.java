package com.victorrot.commons.core.usecases.find;

import com.victorrot.commons.exceptions.ServiceException;
import java.util.Optional;

/**
 * Caso de uso genérico para la búsqueda de una entidad por su identificador
 * y la verificación de su existencia.
 *
 * <p>Esta interfaz define un contrato para consultar una entidad específica 
 * por su ID y para validar si dicha entidad existe. Es utilizada típicamente 
 * en arquitecturas limpias o hexagonales como puerto de entrada (Use Case), 
 * delegando la lógica de acceso a datos a los adaptadores correspondientes.</p>
 * 
 * @author Victor Manuel Rodriguez Ramirez
 * @param <E>  el tipo de la entidad que se desea buscar
 * @param <ID> el tipo del identificador único de la entidad
 * @see ServiceException
 */
public interface FindUseCase<E, ID> {
    
    /**
     * Busca una entidad por su identificador.
     *
     * @param id el identificador único de la entidad
     * @return un {@link Optional} que contiene la entidad encontrada, 
     *         o vacío si no existe.
     * @throws IllegalArgumentException si {@code id} es {@code null}.
     * @throws ServiceException si ocurre un error en la obtención de la entidad.
     */
    Optional<E> findById(ID id);
    
    /**
     * Verifica si existe una entidad con el identificador proporcionado.
     *
     * @param id el identificador único de la entidad.
     * @return {@code true} si la entidad existe, {@code false} en caso contrario.
     * @throws IllegalArgumentException si {@code id} es {@code null}.
     * @throws ServiceException si ocurre un error durante la verificación.
     */
    boolean existsById(ID id);
    
}

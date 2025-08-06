package com.victorrot.commons.core.usecases.find;

import com.victorrot.commons.exceptions.ServiceException;
import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 * Caso de uso genérico para la búsqueda en lote de entidades.
 *
 * <p>Esta interfaz define un contrato para obtener múltiples entidades, ya sea 
 * de forma no paginada o paginada, según el requerimiento. Es utilizada típicamente 
 * en arquitecturas limpias o hexagonales como puerto de entrada (Use Case), 
 * delegando la lógica de acceso a datos a los adaptadores correspondientes.</p>
 * 
 * @author Victor Manuel Rodriguez Ramirez
 * @param <E> el tipo de la entidad que se desea buscar
 * @version 1.0.0
 */
public interface BatchFindUseCase<E> {
    
    /**
     * Recupera todas las entidades disponibles sin paginación.
     * 
     * @return una lista con todas las entidades encontradas.
     * @throws ServiceException si ocurre un error en la obtención de los datos.
     */
    List<E> findAll();
    
    /**
     * Recupera todas las entidades disponibles con paginación.
     * 
     * @param pageable la información de paginación y ordenamiento.
     * @return una página con las entidades encontradas.
     * @throws IllegalArgumentException si {@code pageable} es {@code null}.
     * @throws ServiceException si ocurre un error en la obtención de los datos.
     */
    Page<E> findAll(Pageable pageable);
    
}

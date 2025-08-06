/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.victorrot.commons.core.usecases;

import com.victorrot.commons.core.usecases.delete.DeleteOnlyUseCase;
import com.victorrot.commons.core.usecases.find.ReadOnlyUseCase;
import com.victorrot.commons.core.usecases.persist.PersistenceOnlyUseCase;

/**
 * Caso de uso genérico para operaciones CRUD (Create, Read, Update, Delete) sobre entidades.
 *
 * <p>Esta interfaz combina:</p>
 * <ul>
 *   <li>Lectura individual y en lote desde {@link ReadOnlyUseCase}</li>
 *   <li>Persistencia individual y en lote desde {@link PersistenceOnlyUseCase}</li>
 *   <li>Eliminación individual y en lote desde {@link DeleteOnlyUseCase}</li>
 * </ul>
 *
 * <p>Es utilizada típicamente en arquitecturas limpias o hexagonales, delegando 
 * la lógica de acceso a datos a los adaptadores correspondientes.</p>
 * 
 * @author Victor Manuel Rodriguez Ramirez
 * @param <E>  el tipo de la entidad gestionada
 * @param <ID> el tipo del identificador único de la entidad
 *
 * @see ReadOnlyUseCase
 * @see PersistenceOnlyUseCase
 * @see DeleteOnlyUseCase
 * @see ServiceException
 */
public interface CrudUseCase<E, ID>
        extends ReadOnlyUseCase<E, ID>,
                PersistenceOnlyUseCase<E, ID>,
                DeleteOnlyUseCase<ID> {
    
}

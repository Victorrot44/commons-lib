package com.victorrot.commons.exceptions;

import javax.naming.ConfigurationException;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.BadSqlGrammarException;

/**
 * Enumeración que categoriza tipos de excepciones utilizadas en la aplicación.
 * 
 * <p>
 * Esta enumeración define las categorías generales de excepciones que pueden ocurrir en el sistema. 
 * Cada valor en la enumeración representa una categoría de excepciones, que ayuda a clasificar el tipo de error 
 * ocurrido durante la ejecución. Estas categorías pueden ser utilizadas en conjunto con excepciones personalizadas 
 * o estándar para lanzar, manejar y clasificar los errores de forma más clara.
 * </p>
 * 
 * <p><b>Valores de la enumeración:</b></p>
 * <ul>
 *     <li>{@code GENERAL}: Se refiere a excepciones generales que no encajan en una categoría específica.</li>
 *     <li>{@code CONFIG}: Se refiere a excepciones relacionadas con la condiguración de la aplicación.</li>
 *     <li>{@code DATABASE}: Se refiere a excepciones relacionadas con la base de datos, como errores de SQL, 
 *         conexión o gramática.</li>
 *     <li>{@code VALIDATION}: Se refiere a excepciones que se lanzan cuando hay un error de validación, 
 *         como valores nulos o parámetros inválidos.</li>
 *     <li>{@code SERVICE}: Se refiere a excepciones relacionadas con el uso de servicios externos, como API REST, 
 *         Web Services o recursos remotos.</li>
 * </ul>
 * 
 * <p><b>Ejemplo de uso:</b></p>
 * <pre>
 * try {
 *     // código que podría generar una excepción
 * } catch (Exception e) {
 *     throw new ServiceException(TypeException.DATABASE, "Mensaje de error");
 * }
 * </pre>
 * 
 * <p><b>Notas:</b></p>
 * <ul>
 *     <li>Cada tipo de excepción puede asociarse con una excepción más específica (por ejemplo, 
 *         {@link JDBCException}, {@link SQLGrammarException}, etc.).</li>
 *     <li>Esta enumeración permite tener un control más claro sobre el tipo de error y su manejo.</li>
 * </ul>
 * 
 * @author Victor Manuel Rodriguez Ramirez
 * @version 1.0.0 - New enum
 */
public enum TypeException {
    
    /**
     * Errores generales no categorizados, comúnmente {@code Exception} o {@code RuntimeException}.
     * <p>Utilizada como valor por defecto o para errores que no se pueden clasificar en otras categorías más específicas.</p>
     * 
     * @see Exception
     * @see RuntimeException
     */
    GENERAL,
    /**
     * Errores relacionados con la configuración del sistema o aplicación.
     * <p>Utilizada cuando ocurren errores en la configuración del sistema, como propiedades faltantes,
     * valores de configuración inválidos, o problemas en la inicialización de componentes.</p>
     * 
     * @see ConfigurationException
     */
    CONFIG,
    /**
     * Errores relacionados con el acceso o la integridad de la base de datos.
     * <p>Incluye errores específicos del acceso a la base de datos, como problemas con SQL, errores de gramática SQL,
     * o fallos en la conexión a la base de datos.</p>
     * 
     * @see JDBCException
     * @see BadSqlGrammarException
     * @see DataAccessException
     */
    DATABASE,
    /**
     * Errores relacionados con validaciones de entrada o reglas de negocio.
     * 
     * @see NullPointerException
     * @see IllegalArgumentException
     */
    VALIDATION,
    /**
     * Errores relacionados con servicios externos al sistema o aplicación, talez 
     * como APIs, Web Service, etc.
     */
    SERVICE;
    
}

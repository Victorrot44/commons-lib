package com.victorrot.commons.exceptions;

import javax.naming.ConfigurationException;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.BadSqlGrammarException;

/**
 * Enumeración que categoriza los tipos de excepciones que pueden ocurrir en la 
 * capa de servicio o lógica de negocio.
 * 
 * <p>Esta clasificación permite identificar el origen o naturaleza del error 
 * para facilitar su manejo y trazabilidad.</p>
 * 
 * @author Victor Manuel Rodriguez Ramirez
 * @version 1.0.0 - New enum
 */
public enum TypeException {
    
    /**
     * Errores generales no categorizados, comúnmente {@code Exception} o {@code RuntimeException}.
     * 
     * @see Exception
     * @see RuntimeException
     */
    GENERAL,
    /**
     * Errores relacionados con la configuración del sistema o aplicación.
     * 
     * @see ConfigurationException
     */
    CONFIG,
    /**
     * Errores relacionados con el acceso o la integridad de la base de datos.
     * 
     * @see BadSqlGrammarException
     * @see DataAccessException
     */
    DATABASE,
    /**
     * Errores relacionados con validaciones de entrada o reglas de negocio.
     * 
     * @see IllegalArgumentException
     */
    VALIDATION,
    /**
     * Errores relacionados con servicios externos al sistema o aplicación, talez 
     * como APIs, Web Service, etc.
     */
    SERVICE;
    
}

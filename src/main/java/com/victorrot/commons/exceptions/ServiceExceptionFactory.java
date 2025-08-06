package com.victorrot.commons.exceptions;

import java.util.Objects;
import lombok.extern.slf4j.Slf4j;

/**
 * Fábrica centralizada para la creación de {@link ServiceException} con tipos 
 * específicos de {@link TypeException}, mensajes formateados y métodos 
 * especializados para casos comunes.
 *
 * <p>Su objetivo es estandarizar la creación de excepciones en la capa de 
 * negocio o dominio, evitando la repetición de código y garantizando consistencia 
 * en los mensajes y tipos de error. Puede ser utilizada en cualquier capa que 
 * necesite generar excepciones del dominio.</p>
 *
 * <p>Esta clase es final y tiene un constructor privado para evitar su instanciación.</p>
 *
 * @author Victor Manuel Rodriguez Ramirez
 * @version 1.0.0 - Nueva implementación de fábrica de excepciones
 *
 * @see ServiceException
 * @see TypeException
 */
@Slf4j
public final class ServiceExceptionFactory {
    
    // Constructor privado para evitar instanciación
    private ServiceExceptionFactory() {
        throw new IllegalStateException("Utility class");
    }
    
    private static ServiceException logAndReturn(ServiceException ex) {
        log.error("Type Error: {}", ex.getType());
        log.error("Message: {}", ex.getMessage());
        log.error("Cause: {}", Objects.isNull(ex.getCause()) ? "N/A" : ex.getCause().toString());
        return ex;
    }
    
    // ========== VALIDATION EXCEPTIONS ==========
    
    /**
     * Crea una excepción de validación.
     * 
     * @param message mensaje de error.
     * @return instancia de {@link ServiceException} de tipo {@link TypeException#VALIDATION}
     */
    public static ServiceException validation(String message) {
        return logAndReturn(new ServiceException(TypeException.VALIDATION, message));
    }
    
    /**
     * Crea una excepción de validación.
     * 
     * @param cause excepción original.
     * @return instancia de {@link ServiceException} de tipo {@link TypeException#VALIDATION}
     */
    public static ServiceException validation(Throwable cause) {
        return logAndReturn(new ServiceException(TypeException.VALIDATION, cause));
    }
    
    /**
     * Crea una excepción de validación.
     *
     * @param message mensaje con placeholders <code>{}</code>
     * @param params  parámetros para reemplazar en el mensaje
     * @return instancia de {@link ServiceException} de tipo {@link TypeException#VALIDATION}
     */
    public static ServiceException validation(String message, Object... params) {
        return logAndReturn(new ServiceException(TypeException.VALIDATION, message, params));
    }

    /**
     * Crea una excepción de validación con causa.
     *
     * @param cause   excepción original
     * @param message mensaje con placeholders <code>{}</code>
     * @param params  parámetros para reemplazar en el mensaje
     * @return instancia de {@link ServiceException} de tipo {@link TypeException#VALIDATION}
     */
    public static ServiceException validation(Throwable cause, String message, Object... params) {
        return logAndReturn(new ServiceException(TypeException.VALIDATION, cause, message, params));
    }

    // ========== SERVICE EXCEPTIONS ==========
    
    /**
     * Crea una excepción de servicio.
     * 
     * @param message mensaje de error.
     * @return instancia de {@link ServiceException} de tipo {@link TypeException#SERVICE}
     */
    public static ServiceException service(String message) {
        return logAndReturn(new ServiceException(TypeException.SERVICE, message));
    }
    
    /**
     * Crea una excepción de servicio.
     * 
     * @param cause excepción original.
     * @return instancia de {@link ServiceException} de tipo {@link TypeException#SERVICE}
     */
    public static ServiceException service(Throwable cause) {
        return logAndReturn(new ServiceException(TypeException.SERVICE, cause));
    }
    
    /**
     * Crea una excepción de servicio.
     *
     * @param message mensaje con placeholders <code>{}</code>
     * @param params  parámetros para reemplazar en el mensaje
     * @return instancia de {@link ServiceException} de tipo {@link TypeException#SERVICE}
     */
    public static ServiceException service(String message, Object... params) {
        return logAndReturn(new ServiceException(TypeException.SERVICE, message, params));
    }

    /**
     * Crea una excepción de servicio con causa.
     *
     * @param cause   excepción original
     * @param message mensaje con placeholders <code>{}</code>
     * @param params  parámetros para reemplazar en el mensaje
     * @return instancia de {@link ServiceException} de tipo {@link TypeException#SERVICE}
     */
    public static ServiceException service(Throwable cause, String message, Object... params) {
        return logAndReturn(new ServiceException(TypeException.SERVICE, cause, message, params));
    }

    // ========== DATABASE EXCEPTIONS ==========
    
    /**
     * Crea una excepción de base de datos.
     * 
     * @param message mensaje de error.
     * @return instancia de {@link ServiceException} de tipo {@link TypeException#DATABASE}
     */
    public static ServiceException database(String message) {
        return logAndReturn(new ServiceException(TypeException.DATABASE, message));
    }
    
    /**
     * Crea una excepción de base de datos.
     * 
     * @param cause excepción original.
     * @return instancia de {@link ServiceException} de tipo {@link TypeException#DATABASE}
     */
    public static ServiceException database(Throwable cause) {
        return logAndReturn(new ServiceException(TypeException.DATABASE, cause));
    }
    
    /**
     * Crea una excepción de base de datos.
     *
     * @param message mensaje con placeholders <code>{}</code>
     * @param params  parámetros para reemplazar en el mensaje
     * @return instancia de {@link ServiceException} de tipo {@link TypeException#DATABASE}
     */

    public static ServiceException database(String message, Object... params) {
        return logAndReturn(new ServiceException(TypeException.DATABASE, message, params));
    }

    /**
     * Crea una excepción de base de datos con causa.
     *
     * @param cause   excepción original
     * @param message mensaje con placeholders <code>{}</code>
     * @param params  parámetros para reemplazar en el mensaje
     * @return instancia de {@link ServiceException} de tipo {@link TypeException#DATABASE}
     */
    public static ServiceException database(Throwable cause, String message, Object... params) {
        return logAndReturn(new ServiceException(TypeException.DATABASE, cause, message, params));
    }

    // ========== CONFIGURATION EXCEPTIONS ==========
    
    /**
     * Crea una excepción de configuración.
     * 
     * @param message mensaje de error.
     * @return instancia de {@link ServiceException} de tipo {@link TypeException#CONFIG}
     */
    public static ServiceException config(String message) {
        return logAndReturn(new ServiceException(TypeException.CONFIG, message));
    }
    
    /**
     * Crea una excepción de configuración.
     * 
     * @param cause excepción original.
     * @return instancia de {@link ServiceException} de tipo {@link TypeException#CONFIG}
     */
    public static ServiceException config(Throwable cause) {
        return logAndReturn(new ServiceException(TypeException.CONFIG, cause));
    }
    
    /**
     * Crea una excepción de configuración.
     *
     * @param message mensaje con placeholders <code>{}</code>
     * @param params  parámetros para reemplazar en el mensaje
     * @return instancia de {@link ServiceException} de tipo {@link TypeException#CONFIG}
     */
    public static ServiceException config(String message, Object... params) {
        return logAndReturn(new ServiceException(TypeException.CONFIG, message, params));
    }

    /**
     * Crea una excepción de configuración con causa.
     *
     * @param cause   excepción original
     * @param message mensaje con placeholders <code>{}</code>
     * @param params  parámetros para reemplazar en el mensaje
     * @return instancia de {@link ServiceException} de tipo {@link TypeException#CONFIG}
     */
    public static ServiceException config(Throwable cause, String message, Object... params) {
        return logAndReturn(new ServiceException(TypeException.CONFIG, cause, message, params));
    }
    
    // ========== GENERAL EXCEPTIONS ==========
    
    /**
     * Crea una excepción de general.
     * 
     * @param message mensaje de error.
     * @return instancia de {@link ServiceException} de tipo {@link TypeException#GENERAL}
     */
    public static ServiceException general(String message) {
        return logAndReturn(new ServiceException(TypeException.GENERAL, message));
    }
    
    /**
     * Crea una excepción de general.
     * 
     * @param cause excepción original.
     * @return instancia de {@link ServiceException} de tipo {@link TypeException#GENERAL}
     */
    public static ServiceException general(Throwable cause) {
        return logAndReturn(new ServiceException(TypeException.GENERAL, cause));
    }
    
    /**
     * Crea una excepción general.
     *
     * @param message mensaje con placeholders <code>{}</code>
     * @param params  parámetros para reemplazar en el mensaje
     * @return instancia de {@link ServiceException} de tipo {@link TypeException#GENERAL}
     */
    public static ServiceException general(String message, Object... params) {
        return logAndReturn(new ServiceException(TypeException.GENERAL, message, params));
    }

    /**
     * Crea una excepción general con causa.
     *
     * @param cause   excepción original
     * @param message mensaje con placeholders <code>{}</code>
     * @param params  parámetros para reemplazar en el mensaje
     * @return instancia de {@link ServiceException} de tipo {@link TypeException#GENERAL}
     */
    public static ServiceException general(Throwable cause, String message, Object... params) {
        return logAndReturn(new ServiceException(TypeException.GENERAL, cause, message, params));
    }

    // ========== MÉTODOS DE CONVENIENCIA ==========
    
    /**
     * Crea una excepción genérica con causa, permitiendo especificar el tipo.
     *
     * @param type    tipo de excepción
     * @param message mensaje de error.
     * @return instancia de {@link ServiceException} del tipo especificado
     */
    public static ServiceException of(TypeException type, String message) {
        return logAndReturn(new ServiceException(type, message));
    }
    
    /**
     * Crea una excepción genérica con causa, permitiendo especificar el tipo.
     *
     * @param type    tipo de excepción
     * @param cause   excepción original
     * @return instancia de {@link ServiceException} del tipo especificado
     */
    public static ServiceException of(TypeException type, Throwable cause) {
        return logAndReturn(new ServiceException(type, cause));
    }
    
    /**
     * Crea una excepción genérica permitiendo especificar el tipo.
     *
     * @param type    tipo de excepción
     * @param message mensaje con placeholders <code>{}</code>
     * @param params  parámetros para reemplazar en el mensaje
     * @return instancia de {@link ServiceException} del tipo especificado
     */
    public static ServiceException of(TypeException type, String message, Object... params) {
        return logAndReturn(new ServiceException(type, message, params));
    }

    /**
     * Crea una excepción genérica con causa, permitiendo especificar el tipo.
     *
     * @param type    tipo de excepción
     * @param cause   excepción original
     * @param message mensaje con placeholders <code>{}</code>
     * @param params  parámetros para reemplazar en el mensaje
     * @return instancia de {@link ServiceException} del tipo especificado
     */
    public static ServiceException of(TypeException type, Throwable cause, String message, Object... params) {
        return logAndReturn(new ServiceException(type, cause, message, params));
    }
    
}

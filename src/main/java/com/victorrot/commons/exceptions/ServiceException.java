package com.victorrot.commons.exceptions;

import java.text.MessageFormat;
import java.util.Objects;

/**
 * Excepción personalizada que representa errores o fallos específicos en el servicio.
 * <p>Esta clase extiende {@link RuntimeException} y agrega un campo adicional para clasificar 
 * el tipo de excepción mediante el uso de la enumeración {@link TypeException}. 
 * Permite identificar y manejar errores de una manera más estructurada y organizada, 
 * con un enfoque en el tipo de error que se ha producido, como errores de base de 
 * datos, validaciones fallidas o problemas con servicios externos.</p>
 * 
 * <p><b>Consideraciones de uso:</b></p>
 * <ul>
 *     <li>Esta excepción puede ser lanzada en diferentes puntos del sistema para 
 *         capturar fallos en servicios, validaciones o recursos externos.</li>
 *     <li>El tipo de excepción {@link TypeException} permite una clasificación 
 *         y categorización más fácil de los errores.</li>
 * </ul>
 * 
 * <p><b>Ejemplo de uso:</b></p>
 * <pre>
 * try {
 *     // código que puede generar una excepción
 * } catch (SomeException e) {
 *     throw new ServiceException("Mensaje de error detallado", TypeException.DATABASE);
 * }
 * </pre>
 * @author Victor Manuel Rodriguez Ramirez
 * @version 1.0.0 - Nueva implementacion de excepción personalizada.
 * @see TypeException
 */
public class ServiceException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    private static final String DEFAULT_MESSAGE = "Ha ocurrido un error inesperado.";

    /** Tipo de excepción que clasifica el error ocurrido. */
    private TypeException type;

    /**
     * Formatea un mensaje con parámetros reemplazando las ocurrencias de "{}" con
     * los valores proporcionados.
     * 
     * @param text      El mensaje base con marcadores "{}" para reemplazar.
     * @param params    Los parámetros a insertar en el mensaje.
     * @return El mensaje formateado con los parámetros sustituidos.
     */
    private static String formatMessage(String text, Object... params) {
        StringBuilder formattedText = new StringBuilder();
        int paramIndex = 0, lastIndex = 0;
        while ((lastIndex = text.indexOf("{}", lastIndex)) != -1 && paramIndex < params.length) {
            formattedText.append(text, 0, lastIndex)
                    .append("{").append(paramIndex++).append("}");
            text = text.substring(lastIndex + 2);
            lastIndex = 0;
        }
        formattedText.append(text);
        return MessageFormat.format(formattedText.toString(), params);
    }

    /**
     * Crea una nueva instancia de <code>ServiceException</code> sin mensaje 
     * detallado ni tipo específico.
     * 
     * <p>Este constructor se utiliza cuando no se necesita proporcionar un mensaje 
     * detallado ni un tipo de excepción específico, asignando el tipo por defecto
     * {@link TypeException#GENERAL}.</p>
     * 
     * @deprecated Este constructor ya no es recomendado; se sugiere usar otros 
     *             constructores con mensajes específicos o tipos de excepción.
     */
    @Deprecated
    public ServiceException() {
        this((TypeException)null, (Throwable)null, "Ha ocurrido un error inesperado.");
    }

    /**
     * Crea una nueva instancia de <code>ServiceException</code> con el mensaje 
     * detallado especificado y un tipo de excepción por defecto 
     * {@link TypeException#GENERAL}.
     * 
     * @param msg El mensaje detallado que describe el error.
     */
    public ServiceException(String msg) {
        this((TypeException)null, (Throwable)null, msg);
    }

    /**
     * Crea una nueva instancia de <code>ServiceException</code> con el mensaje 
     * detallado especificado formateado y un tipo de excepción por defecto 
     * {@link TypeException#GENERAL}.
     * 
     * @param msg El mensaje detallado con los marcadores de formato (como "{}").
     * @param params Los parámetros a ser insertados en el mensaje.
     *               Se formatean usando {@link String#format(java.lang.String, java.lang.Object...)}.
     * @see String#format(java.lang.String, java.lang.Object...) 
     */
    public ServiceException(String msg, Object... params) {
        this(null, null, msg, params);
    }

    /**
     * Crea una nueva instancia de <code>ServiceException</code> con la causa 
     * de la excepción especificada y un tipo de excepción por defecto 
     * {@link TypeException#GENERAL}.
     * 
     * @param cause La causa original de la excepción.
     */
    public ServiceException(Throwable cause) {
        this((TypeException)null, cause, "Ha ocurrido un error inesperado.");
    }

    /**
     * Crea una nueva instancia de <code>ServiceException</code> con el mensaje 
     * detallado y la causa de la excepción.
     * 
     * @param msg El mensaje detallado que describe el error.
     * @param cause La causa original de la excepción.
     */
    public ServiceException(String msg, Throwable cause) {
        this((TypeException)null, cause, msg);
    }

    /**
     * Crea una nueva instancia de <code>ServiceException</code> con la causa 
     * de la excepción y el mensaje detallado formateado y un tipo de excepción 
     * por defecto {@link TypeException#GENERAL}.
     * 
     * @param cause La causa original de la excepción.
     * @param msg El mensaje detallado con los marcadores de formato (como "{}").
     * @param params Los parámetros a ser insertados en el mensaje.
     *               Se formatean usando {@link String#format(java.lang.String, java.lang.Object...)}.
     * @see String#format(java.lang.String, java.lang.Object...) 
     */
    public ServiceException(Throwable cause, String msg, Object... params) {
        this(null, cause, msg, params);
    }

    /**
     * Crea una nueva instancia de <code>ServiceException</code> con el mensaje 
     * detallado especificado y un tipo de excepción específico.
     * 
     * <p>Este constructor permite especificar el tipo de la excepción 
     * (por ejemplo, {@link TypeException#DATABASE}, {@link TypeException#VALIDATION}) 
     * junto con el mensaje detallado.</p>
     * 
     * @param type El tipo de excepción {@link TypeException} que clasifica el error.
     * @param msg El mensaje detallado que describe el error.
     */
    public ServiceException(TypeException type, String msg) {
        this(type, (Throwable)null, msg);
    }

    /**
     * Crea una nueva instancia de <code>ServiceException</code> con el mensaje 
     * detallado formateado con los parámetros y un tipo de excepción específico.
     * 
     * @param type El tipo de excepción {@link TypeException} que clasifica el error.
     * @param msg El mensaje detallado con los marcadores de formato (como "{}").
     * @param params Los parámetros a ser insertados en el mensaje.
     *               Se formatean usando {@link String#format(java.lang.String, java.lang.Object...)}.
     * @see String#format(java.lang.String, java.lang.Object...) 
     */
    public ServiceException(TypeException type, String msg, Object... params) {
        this(type, null, msg, params);
    }

    /**
     * Crea una nueva instancia de <code>ServiceException</code> con la causa de 
     * la excepción y un tipo de excepción específico.
     * 
     * <p>Este constructor permite asociar una causa de la excepción con un tipo 
     * de excepción específico.</p>
     * 
     * @param type El tipo de excepción {@link TypeException} que clasifica el error.
     * @param cause La causa original de la excepción.
     */
    public ServiceException(TypeException type, Throwable cause) {
        this(type, cause, "Ha ocurrido un error inesperado.");
    }

    /**
     * Crea una nueva instancia de <code>ServiceException</code> con el mensaje 
     * detallado, la causa de la excepción y el tipo de excepción específico.
     * 
     * <p>Este constructor permite crear una excepción completa con un mensaje, 
     * una causa y un tipo de excepción. </p>
     * 
     * @param type El tipo de excepción {@link TypeException} que clasifica el error.
     * @param cause La causa original de la excepción.
     * @param msg El mensaje detallado que describe el error.
     */
    public ServiceException(TypeException type, Throwable cause, String msg) {
        super(msg, cause);
        this.type = Objects.<TypeException>requireNonNullElse(type, TypeException.GENERAL);
    }

    /**
     * Crea una nueva instancia de <code>ServiceException</code> con el tipo de excepción 
     * y la causa de la excepción, además del mensaje detallado formateado.
     * 
     * @param type El tipo de excepción {@link TypeException}.
     * @param cause La causa original de la excepción.
     * @param msg El mensaje detallado con los marcadores de formato (como "{}").
     * @param params Los parámetros a ser insertados en el mensaje.
     *               Se formatean usando {@link String#format(java.lang.String, java.lang.Object...)}.
     * @see String#format(java.lang.String, java.lang.Object...) 
     */
    public ServiceException(TypeException type, Throwable cause, String msg, Object... params) {
        super(formatMessage(msg, params), cause);
        this.type = Objects.<TypeException>requireNonNullElse(type, TypeException.GENERAL);
    }

    /**
     * Obtiene el tipo de excepción {@link TypeException} que clasifica el error 
     * ocurrido.
     * 
     * @return El tipo de excepción {@link TypeException} asociado a esta instancia 
     * de <code>ServiceException</code>.
     */
    public TypeException getType() {
        return this.type;
    }

}

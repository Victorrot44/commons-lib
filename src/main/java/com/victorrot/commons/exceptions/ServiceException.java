package com.victorrot.commons.exceptions;

import java.text.MessageFormat;
import java.util.Objects;

/**
 * Excepción personalizada para representar errores.
 * 
 * <p>Esta excepción es verificada en tiempo de ejecución, ya que hereda de {@link RuntimeException}. 
 * Se recomienda lanzarla únicamente en casos de uso o servicios de aplicación.</p>
 * 
 * @author Victor Manuel Rodriguez Ramirez
 * @version 1.0.0 - Nueva implementacion de excepción personalizada.
 * @see TypeException
 */
public class ServiceException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    private static final String DEFAULT_MESSAGE = "Ha ocurrido un error inesperado.";

    private TypeException type;

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

    @Deprecated
    public ServiceException() {
        this((TypeException)null, (Throwable)null, "Ha ocurrido un error inesperado.");
    }

    public ServiceException(String msg) {
        this((TypeException)null, (Throwable)null, msg);
    }

    public ServiceException(String msg, Object... params) {
        this(null, null, msg, params);
    }

    public ServiceException(Throwable cause) {
        this((TypeException)null, cause, "Ha ocurrido un error inesperado.");
    }

    public ServiceException(String msg, Throwable cause) {
        this((TypeException)null, cause, msg);
    }

    public ServiceException(Throwable cause, String msg, Object... params) {
        this(null, cause, msg, params);
    }

    public ServiceException(TypeException type, String msg) {
        this(type, (Throwable)null, msg);
    }

    public ServiceException(TypeException type, String msg, Object... params) {
        this(type, null, msg, params);
    }

    public ServiceException(TypeException type, Throwable cause) {
        this(type, cause, "Ha ocurrido un error inesperado.");
    }

    public ServiceException(TypeException type, Throwable cause, String msg) {
        super(msg, cause);
        this.type = Objects.<TypeException>requireNonNullElse(type, TypeException.GENERAL);
    }

    public ServiceException(TypeException type, Throwable cause, String msg, Object... params) {
        super(formatMessage(msg, params), cause);
        this.type = Objects.<TypeException>requireNonNullElse(type, TypeException.GENERAL);
    }

    public TypeException getType() {
        return this.type;
    }

}

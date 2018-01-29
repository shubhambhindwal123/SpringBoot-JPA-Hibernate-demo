package com.shubh.exception.handler;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.context.request.WebRequest;

import com.shubh.dto.ErrorDTO;
import com.shubh.dto.MessageType;
import com.shubh.exception.custom.AppDemoMessageException;

/**
 * This handle all the validation
 * 
 * @author Shubham Bhindwal
 *
 */
@ControllerAdvice
public class ControllerValidationHandler {

    final static Logger logger = Logger.getLogger(ControllerValidationHandler.class);

    final static List<String> businessErrorMessage = Arrays.asList("Somthing went wrong..");

    @Autowired
    private MessageSource messageSource;

    /**
     * Method for handling MethodArgumentNotValidException Exception
     * 
     * @param exception
     * @return {@link ErrorDTO}
     */
    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody
    public ErrorDTO processValidationError(MethodArgumentNotValidException ex) {
        logger.info("Inside processValidationError ");

        BindingResult result = ex.getBindingResult();
        List<FieldError> errors = result.getFieldErrors();

        logger.info("Inside processValidationError ");
        return processFieldError(errors);
    }

    /**
     * 
     * @param errors
     * @return ErrorDTO
     */
    private ErrorDTO processFieldError(List<FieldError> errors) {
        logger.info("Inside processFieldError ");

        ErrorDTO message = null;
        List<String> messages = new ArrayList<String>();
        errors.forEach((error) -> {
            if (error != null) {
                Locale currentLocale = LocaleContextHolder.getLocale();
                String msg = messageSource.getMessage(error.getDefaultMessage(), new String[] { error.getField() },
                        currentLocale);
                messages.add(msg);
            }
        });
        message = new ErrorDTO(messages, MessageType.ERROR);
        logger.info("Inside processFieldError ");
        return message;
    }

    /**
     * 
     * @param AppDemoMessageException
     * @param WebRequest
     * @return ResponseEntity<ErrorDTO>
     */
    @ExceptionHandler(value = AppDemoMessageException.class)
    protected ResponseEntity<ErrorDTO> handleConflict(AppDemoMessageException exception, WebRequest request) {
        logger.debug("Inside method: handleConflict() handling exception");
        logger.error("Exception message: " + exception.getMessage());
        logger.debug("Exception: " + exception);
        ErrorDTO message = new ErrorDTO();
        message.setMessage(Arrays.asList(exception.getMessage()));
        message.setType(MessageType.ERROR);
        System.out.println(exception.getType());
        logger.debug("Inside method: handleConflict() handling exception");
        return new ResponseEntity<ErrorDTO>(message, exception.getType());
    }

    /**
     * 
     * @param HttpMessageNotReadableException
     * @return ErrorDTO
     */
    @ExceptionHandler({ HttpMessageNotReadableException.class, SQLException.class, IllegalStateException.class })
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ResponseBody
    public ErrorDTO handleBusinessException(HttpMessageNotReadableException ex) {
        ErrorDTO message = new ErrorDTO(businessErrorMessage, MessageType.ERROR);
        return message;
    }

}

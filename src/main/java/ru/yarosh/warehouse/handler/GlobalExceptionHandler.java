package ru.yarosh.warehouse.handler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import ru.yarosh.warehouse.handler.exception.ResourceNotFoundException;

/**
 * Глобальный обработчик исключений для приложения склада.
 */
@ControllerAdvice
public class GlobalExceptionHandler {

    /**
     * Обрабатывает исключение ResourceNotFoundException.
     *
     * @param ex      исключение ResourceNotFoundException
     * @param request HTTP запрос
     * @return ответ с сообщением об ошибке и статусом 404 Not Found
     */
    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<Object> handleResourceNotFoundException(ResourceNotFoundException ex, WebRequest request) {
        String errorMessage = "Resource not found";
        return new ResponseEntity<>(errorMessage, HttpStatus.NOT_FOUND);
    }

    /**
     * Обрабатывает другие исключения.
     *
     * @param ex      другие исключения
     * @param request HTTP запрос
     * @return ответ с сообщением об ошибке и статусом 500 Internal Server Error
     */
    @ExceptionHandler(Exception.class)
    public ResponseEntity<Object> handleOtherExceptions(Exception ex, WebRequest request) {
        String errorMessage = "Error happened: " + ex.getMessage();
        return new ResponseEntity<>(errorMessage, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}

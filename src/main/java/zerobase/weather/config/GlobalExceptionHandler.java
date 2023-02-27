package zerobase.weather.config;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import zerobase.weather.error.InvalidDate;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(InvalidDate.class)
    public String handleInvalidException(){
        return new InvalidDate().getMessage();

    }

    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(Exception.class)
    public Exception handleException() {
        return new Exception();
    }
}

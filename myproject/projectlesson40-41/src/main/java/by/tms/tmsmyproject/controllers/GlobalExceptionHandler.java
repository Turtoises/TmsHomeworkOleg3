package by.tms.tmsmyproject.controllers;

import by.tms.tmsmyproject.exception.MyException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.NoHandlerFoundException;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(value = {NoHandlerFoundException.class, MyException.class})
    public String notFoundException() {
        return "404";
    }
}

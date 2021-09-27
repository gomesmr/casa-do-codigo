package com.zupacademy.casadocodigo.validator;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ErrosDeValidacaoHandler {

    @Autowired
    private MessageSource messageSource;

    @ResponseStatus(code= HttpStatus.BAD_REQUEST)
    @ExceptionHandler({MethodArgumentNotValidException.class, IllegalStateException.class, NoSuchElementException.class})
    public List<ErrosDadosDto> handle (MethodArgumentNotValidException exception){
        List<ErrosDadosDto> dto = new ArrayList<>();
        List<FieldError> fe = exception.getBindingResult().getFieldErrors();
        fe.forEach(e -> dto.add(new ErrosDadosDto(e.getField().toString(), messageSource.getMessage(e, LocaleContextHolder.getLocale())  )));
        return dto;
    }
}

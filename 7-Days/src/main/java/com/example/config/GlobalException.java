package com.example.config;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.*;

@RestControllerAdvice
@Slf4j
public class GlobalException extends ResponseEntityExceptionHandler {


    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        Map<String, Object> hm = new LinkedHashMap<>();
        List<Map> ls = errorsParse(ex);
        hm.put("status", false);
        hm.put("errors", ls );
        ls.forEach( item -> {
            log.error( item.toString() );
        } );
        return new ResponseEntity(hm, HttpStatus.BAD_REQUEST);
    }


    public List errorsParse(MethodArgumentNotValidException ex) {
        List<Map<String, String>> ls = new ArrayList<>();
        for ( FieldError item : ex.getFieldErrors() ) {
            Map<String , String > hmx = new HashMap<>();
            String field = item.getField();
            String message = item.getDefaultMessage();
            hmx.put( field, message );
            ls.add(hmx);
        }
        return ls;
    }

}

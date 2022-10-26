package com.api.guildapplication.exception;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.NoSuchElementException;

@RestControllerAdvice
public class ExceptionConfig {

    @ExceptionHandler({NoSuchElementException.class})
    public ResponseEntity errorNotFound(Exception ex){
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Member not found.");
    }

    @ExceptionHandler({DataIntegrityViolationException.class})
    public ResponseEntity errorConflict(Exception ex){
        return ResponseEntity.status(HttpStatus.CONFLICT).body("Character name already in use.");
    }
}

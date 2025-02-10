package com.zuzex.education.exception;

import com.zuzex.education.dto.ErrorDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
@Slf4j
public class GlobalExceptionHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Object> handleValidationException(MethodArgumentNotValidException ex) {
        log.error(ex.getMessage());
        return new ResponseEntity<>(
                new ErrorDTO(HttpStatus.BAD_REQUEST.value(), ex.getMessage()),
                HttpStatus.BAD_REQUEST
        );
    }
    @ExceptionHandler(AddressNotFoundException.class)
    public ResponseEntity<Object> handleAddressNotFoundException(AddressNotFoundException ex) {
        log.error(ex.getMessage());
        return new ResponseEntity<>(
                new ErrorDTO(HttpStatus.NOT_FOUND.value(), ex.getMessage()),
                HttpStatus.NOT_FOUND
        );
    }

    @ExceptionHandler(CarNotFoundException.class)
    public ResponseEntity<Object> handleCarNotFoundException(CarNotFoundException ex) {
        log.error(ex.getMessage());
        return new ResponseEntity<>(
                new ErrorDTO(HttpStatus.NOT_FOUND.value(), ex.getMessage()),
                HttpStatus.NOT_FOUND
        );
    }

    @ExceptionHandler(OwnerCarNotFoundException.class)
    public ResponseEntity<Object> handleOwnerCarNotFoundException(OwnerCarNotFoundException ex) {
        log.error(ex.getMessage());
        return new ResponseEntity<>(
                new ErrorDTO(HttpStatus.NOT_FOUND.value(), ex.getMessage()),
                HttpStatus.NOT_FOUND
        );
    }

    @ExceptionHandler(HouseNotFoundException.class)
    public ResponseEntity<Object> handleHouseNotFoundException(HouseNotFoundException ex) {
        log.error(ex.getMessage());
        return new ResponseEntity<>(
                new ErrorDTO(HttpStatus.NOT_FOUND.value(), ex.getMessage()),
                HttpStatus.NOT_FOUND
        );
    }

    @ExceptionHandler(OwnerHouseNotFoundException.class)
    public ResponseEntity<Object> handleOwnerHouseNotFoundException(OwnerHouseNotFoundException ex) {
        log.error(ex.getMessage());
        return new ResponseEntity<>(
                new ErrorDTO(HttpStatus.NOT_FOUND.value(), ex.getMessage()),
                HttpStatus.NOT_FOUND
        );
    }

    @ExceptionHandler(PassportNotFoundException.class)
    public ResponseEntity<Object> handlePassportNotFoundException(PassportNotFoundException ex) {
        log.error(ex.getMessage());
        return new ResponseEntity<>(
                new ErrorDTO(HttpStatus.NOT_FOUND.value(), ex.getMessage()),
                HttpStatus.NOT_FOUND
        );
    }

    @ExceptionHandler(MalePassportNotFoundException.class)
    public ResponseEntity<Object> handlePassportNotFoundException(MalePassportNotFoundException ex) {
        log.error(ex.getMessage());
        return new ResponseEntity<>(
                new ErrorDTO(HttpStatus.NOT_FOUND.value(), ex.getMessage()),
                HttpStatus.NOT_FOUND
        );
    }

    @ExceptionHandler(PersonNotFoundException.class)
    public ResponseEntity<Object> handlePeopleNotFoundException(PersonNotFoundException ex) {
        log.error(ex.getMessage());
        return new ResponseEntity<>(
                new ErrorDTO(HttpStatus.NOT_FOUND.value(), ex.getMessage()),
                HttpStatus.NOT_FOUND
        );
    }

}

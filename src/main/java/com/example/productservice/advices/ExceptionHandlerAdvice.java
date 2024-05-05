package com.example.productservice.advices;

import com.example.productservice.DTOs.ArithmeticExceptionDTO;
import com.example.productservice.DTOs.ArrayOutOfBoundExceptionDTO;
import com.example.productservice.DTOs.ExceptionDTO;
import com.example.productservice.Exceptions.InvalidProductIdException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionHandlerAdvice {

    @ExceptionHandler(ArithmeticException.class)
    public ResponseEntity<ArithmeticExceptionDTO>  handleArithmeticException(){
        ArithmeticExceptionDTO arithmeticExceptionDTO= new ArithmeticExceptionDTO();
        arithmeticExceptionDTO.setMessage("something went wrong");
        return new ResponseEntity<>(arithmeticExceptionDTO, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(ArrayIndexOutOfBoundsException.class)
    public ResponseEntity<ArrayOutOfBoundExceptionDTO>  handleArrayOutOfBoundException(){
       ArrayOutOfBoundExceptionDTO arrayOutOfBoundExceptionDTO = new ArrayOutOfBoundExceptionDTO();
        arrayOutOfBoundExceptionDTO.setMessage("something went wrong");
        return new ResponseEntity<>(arrayOutOfBoundExceptionDTO, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(InvalidProductIdException.class)
    public ResponseEntity<ExceptionDTO> handleInvalidIdException(InvalidProductIdException exception){
        ExceptionDTO exceptionDTO= new ExceptionDTO();
        exceptionDTO.setId(exception.getProductId());
        exceptionDTO.setMessage("Invalid Id");
        return new ResponseEntity<>(exceptionDTO,HttpStatus.BAD_REQUEST);
    }
}

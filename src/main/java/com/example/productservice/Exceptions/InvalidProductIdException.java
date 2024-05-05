package com.example.productservice.Exceptions;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class InvalidProductIdException extends Exception{

    private Long ProductId;
    public InvalidProductIdException(Long ProductId, String message){
        super(message);
        this.ProductId=ProductId;
    }
}

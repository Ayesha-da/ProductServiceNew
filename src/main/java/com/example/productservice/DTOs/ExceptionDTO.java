package com.example.productservice.DTOs;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ExceptionDTO {
    private Long Id;
    private String message;
    private String details;
}

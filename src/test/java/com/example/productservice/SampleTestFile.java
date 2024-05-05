package com.example.productservice;

import com.example.productservice.Exceptions.InvalidProductIdException;
import com.example.productservice.controllers.ProductController;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;
import static org.skyscreamer.jsonassert.JSONAssert.assertEquals;


@SpringBootTest
public class SampleTestFile {


    @Autowired
    private ProductController productController;
    @Test
    void testOnePlusOneTwo(){
        //3 A's
        int i=1+1;
        assert i==2;
    }

    @Test
    void testtwomuliplytwo() {
        int x=2*2;
        int y=3*3;
        assert x==4;
       // assert  y==9 ;
        Assertions.assertEquals(7,y, "value is not equal");
        assertNotEquals(x,y);
     //   assertNull();// check if null then pass
      //  assertThrows(InvalidProductIdException.class,
       //         () -  productController.getProducBytId(1000L));

       // assertTrue();
    }
}

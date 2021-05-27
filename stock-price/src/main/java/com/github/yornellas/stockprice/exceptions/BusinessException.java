package com.github.yornellas.stockprice.exceptions;

public class BusinessException extends RuntimeException{

    public BusinessException(String message) {
        super(message); //propaga a mensagem pro RuntimeException
    }

}

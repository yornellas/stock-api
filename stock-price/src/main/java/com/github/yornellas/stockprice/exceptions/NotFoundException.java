package com.github.yornellas.stockprice.exceptions;

import com.github.yornellas.stockprice.util.MessageUtils;

public class NotFoundException extends RuntimeException{

    public NotFoundException() {
        super(MessageUtils.NO_RECORDS_FOUND);
    }

}

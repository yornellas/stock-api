package com.github.yornellas.stockprice.service;

import com.github.yornellas.stockprice.exceptions.BusinessException;
import com.github.yornellas.stockprice.mapper.StockMapper;
import com.github.yornellas.stockprice.model.Stock;
import com.github.yornellas.stockprice.model.dto.StockDTO;
import com.github.yornellas.stockprice.repository.StockRepository;
import com.github.yornellas.stockprice.util.MessageUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;


@Service
public class StockService {

    @Autowired
    private StockRepository repository;

    @Autowired
    private StockMapper mapper;

    @Transactional
    public StockDTO save(StockDTO dto) {

        Optional<Stock> optionalStock = repository.findByNameAndDate(dto.getName(), dto.getDate());
        if(optionalStock.isPresent()) {
            throw new BusinessException(MessageUtils.STOCK_ALREADY_EXISTS);
        }

        Stock stock = mapper.toEntity(dto);
        repository.save(stock);
        return mapper.toDto(stock);
    }
}

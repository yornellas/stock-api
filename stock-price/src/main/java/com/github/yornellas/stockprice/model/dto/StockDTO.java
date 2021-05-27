package com.github.yornellas.stockprice.model.dto;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

//Data Transfer Object - esse objeto que interage com o Controller
public class StockDTO {

                    //não coloca @NotNull nesse, pois no caso do POST, o valor virá null, pois quem irá prover o id é o bando de dados
    private Long id;

    @NotNull //para validação de dados (garante que a app não vai quebrar recebendo dado errado)
    private String name;

    @NotNull
    @DecimalMin(value = "0.00") //Validação para não poder ter um decimal < 0
    @Digits(integer = 6, fraction = 2) //Validação para o tamanho máximo ser 6 dígitos e 2 casas decimais
    private Double price;

    @NotNull
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy") //Formatação da data
    private LocalDate date;

    @NotNull
    @Digits(integer = 3, fraction = 2)
    private Double variation;  //se vier algum dado null, automaticamente devolve um code response: 400 - bad request

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public Double getVariation() {
        return variation;
    }

    public void setVariation(Double variation) {
        this.variation = variation;
    }
}

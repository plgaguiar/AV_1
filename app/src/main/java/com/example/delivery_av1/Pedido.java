package com.example.delivery_av1;

import java.io.Serializable;

public class Pedido implements Serializable {

    private Integer id;
    private String produto;
    private String acomp1;
    private String valor;
    private String quantidade;
    private String total;
    private String obs;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getProduto() {
        return produto;
    }

    public void setProduto(String produto) {
        this.produto = produto;
    }

    public String getAcomp1() {
        return acomp1;
    }

    public void setAcomp1(String acomp1) {
        this.acomp1 = acomp1;
    }

    public String getValor() {
        return valor;
    }

    public void setValor(String valor) {
        this.valor = valor;
    }

    public String getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(String quantidade) {
        this.quantidade = quantidade;
    }

    public String getTotal() {
        return total;
    }

    public void setTotal(String total) {
        this.total = total;
    }

    public String getObs() {
        return obs;
    }

    public void setObs(String obs) {
        this.obs = obs;
    }

    @Override
    public String toString(){
        return produto;
    }


}

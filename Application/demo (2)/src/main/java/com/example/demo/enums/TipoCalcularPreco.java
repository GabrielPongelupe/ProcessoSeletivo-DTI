package com.example.demo.enums;

public enum TipoCalcularPreco {
    ADICIONAL_FIXO("ADICIONAL_FIXO"),
    ADICIONAL_PERCENTUAL("ADICIONAL_PERCENTUAL"),
    NENHUM("NENHUM");

    public String value;

    TipoCalcularPreco(String value){
        this.value = value;
    }

    public String getValue(){
        return this.value;
    }
}

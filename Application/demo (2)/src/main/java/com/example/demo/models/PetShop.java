package com.example.demo.models;

import java.time.DayOfWeek;
import java.time.LocalDate;

import io.micrometer.common.lang.NonNull;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import com.example.demo.enums.TipoCalcularPreco; 

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "petShop")
public class PetShop {
    
    @Id
    @Column(name= "id", unique = true)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @NonNull
    private Long id;

    @Column(name= "nome", nullable = false)
    private String nome;

    @Column(name = "distancia", nullable = false)
    private Double distancia;

    @Column(name = "preco_CaoPequeno", nullable = false)
    private Double preco_CaoPequeno;

    @Column(name = "preco_CaoGrande", nullable = false)
    private Double preco_CaoGrande;

    @Column(name = "metodo_Calcular_Preço", nullable = false)
    private TipoCalcularPreco metodo_Calcular_Preço;

    @Column(name = "adicional_FimDeSemana")
    private Double adicional_FimDeSemana;

    

    public Double calcularPreco(LocalDate data, int caesGrandes, int caesPequenos){
        //verifica dia da semana
        if(data.getDayOfWeek() == DayOfWeek.SATURDAY || data.getDayOfWeek() == DayOfWeek.SUNDAY){

            //ifs verificando tipo de adicional no fim de semana e implementando logica
            if(this.metodo_Calcular_Preço == TipoCalcularPreco.ADICIONAL_FIXO){
                Double preco_caes_pequenos = (this.preco_CaoPequeno + this.adicional_FimDeSemana) * caesPequenos;
                Double preco_caes_grandes = (this.preco_CaoGrande + this.adicional_FimDeSemana) * caesGrandes;

                return preco_caes_grandes + preco_caes_pequenos;
            }

            if(this.metodo_Calcular_Preço == TipoCalcularPreco.ADICIONAL_PERCENTUAL){
                Double preco_caes_pequenos = (this.preco_CaoPequeno * this.adicional_FimDeSemana) * caesPequenos;
                Double preco_caes_grandes = (this.preco_CaoGrande * this.adicional_FimDeSemana) * caesGrandes;

                return preco_caes_grandes + preco_caes_pequenos;
            }

            else{
                return (caesGrandes * this.preco_CaoGrande) + (caesPequenos * this.preco_CaoPequeno);
            }
        }else{
            return (caesGrandes * this.preco_CaoGrande) + (caesPequenos * this.preco_CaoPequeno);
        }
        

    }

}

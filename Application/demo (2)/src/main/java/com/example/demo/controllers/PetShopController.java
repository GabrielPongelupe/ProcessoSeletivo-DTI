package com.example.demo.controllers;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.example.demo.DTOs.PetShopRequest;
import com.example.demo.DTOs.PetShopReturn;
import com.example.demo.enums.TipoCalcularPreco;
import com.example.demo.models.PetShop;
import com.example.demo.services.PetShopService;

import jakarta.annotation.PostConstruct;

import java.net.URI;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;





@RestController
@RequestMapping("/petShop")
@Validated
public class PetShopController {
    @Autowired
    public PetShopService petShopService;

    @GetMapping("/{id}")
    public ResponseEntity<PetShop> findById(@PathVariable Long id) {
        return ResponseEntity.ok(this.petShopService.findById(id));
    }

    @PostMapping
    public ResponseEntity<PetShop> create(@RequestBody PetShop petShop) {
        this.petShopService.create(petShop);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(petShop.getId()).toUri();
        
        return ResponseEntity.created(uri).build();
    }

    
    @PostConstruct
    public void init() {
        // Crie um novo PetShop com atributos padrão
        PetShop petShop = new PetShop();
        petShop.setId(1L);
        petShop.setNome("Meu Canino Feliz");
        petShop.setDistancia(2.0);
        petShop.setPreco_CaoPequeno(20.0);
        petShop.setPreco_CaoGrande(40.0);
        petShop.setMetodo_Calcular_Preço(TipoCalcularPreco.ADICIONAL_PERCENTUAL);
        petShop.setAdicional_FimDeSemana(120.0);

        PetShop petShop2 = new PetShop();
        petShop2.setId(2L);
        petShop2.setNome("Vai Rex");
        petShop2.setDistancia(1.7);
        petShop2.setPreco_CaoPequeno(15.0);
        petShop2.setPreco_CaoGrande(50.0);
        petShop2.setMetodo_Calcular_Preço(TipoCalcularPreco.ADICIONAL_FIXO);
        petShop2.setAdicional_FimDeSemana(5.0);

        PetShop petShop3 = new PetShop();
        petShop3.setId(3L);
        petShop3.setNome("ChowChawgas");
        petShop3.setDistancia(0.8);
        petShop3.setPreco_CaoPequeno(30.0);
        petShop3.setPreco_CaoGrande(45.0);
        petShop3.setMetodo_Calcular_Preço(TipoCalcularPreco.NENHUM);
        petShop3.setAdicional_FimDeSemana(0.0);

        // Salve o PetShop no banco de dados usando o serviço
        petShopService.create(petShop);
        petShopService.create(petShop2);
        petShopService.create(petShop3);
    }

    @PutMapping("/{id}")
    public ResponseEntity<PetShop> update(@PathVariable("id") Long id, @RequestBody PetShop petShop) {
        petShop.setId(id);
        this.petShopService.update(petShop);
        return ResponseEntity.noContent().build();
    }

    // Método para buscar o PetShop com menor preço total com base nos parâmetros fornecidos
    @PostMapping("/melhorPreco")
    public ResponseEntity<PetShopReturn> findPetShopWithLowestPrice(
            @RequestBody PetShopRequest request) {
        
        LocalDate data = parseData(request.getData());
        
        PetShop petShop = petShopService.findPetShopWithLowestPrice(data, request.getCaesGrandes(), request.getCaesPequenos());
        PetShopReturn petShopReturn = new PetShopReturn(petShop, petShop.calcularPreco(data, request.getCaesGrandes(), request.getCaesPequenos()));
        return ResponseEntity.ok(petShopReturn);
    }

    public LocalDate parseData(String data) {
        try {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            LocalDate localDate = LocalDate.parse(data, formatter);
            return localDate;
        } catch (DateTimeParseException e) {
            System.err.println("Erro ao fazer parse da data. Formato incorreto: " + data);
            return null;
        }
    }
}

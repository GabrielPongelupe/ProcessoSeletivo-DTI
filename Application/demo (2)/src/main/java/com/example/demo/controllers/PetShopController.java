package com.example.demo.controllers;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.example.demo.DTOs.PetShopRequest;
import com.example.demo.DTOs.PetShopReturn;
import com.example.demo.models.PetShop;
import com.example.demo.services.PetShopService;


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

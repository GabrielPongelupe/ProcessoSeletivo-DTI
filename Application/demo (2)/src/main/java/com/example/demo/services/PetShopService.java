package com.example.demo.services;

import java.time.LocalDate;
import java.util.Optional;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.models.PetShop;
import com.example.demo.repositories.PetShopRepository;

import io.micrometer.common.lang.NonNull;
import jakarta.transaction.Transactional;

@Service
public class PetShopService {
    @Autowired
    public PetShopRepository petShopRepository;

    public PetShop findById(@NonNull Long id){
        Optional<PetShop> petShop = this.petShopRepository.findById(id);

        return petShop.orElseThrow(() -> new RuntimeException(
            "Objeto não encontrado | id = " + id + ", Tipo = " + PetShop.class.getName()));
    }


    @Transactional
    public PetShop create(@NonNull PetShop petShop){
        return this.petShopRepository.save(petShop);
    }

    @Transactional 
    public PetShop update(@NonNull PetShop petShop){
        PetShop newPetShop = findById(petShop.getId());
        return petShopRepository.save(newPetShop);
    }

    public PetShop findPetShopWithLowestPrice(LocalDate data, int caesGrandes, int caesPequenos) {
        List<PetShop> petShops = petShopRepository.findAll();
        PetShop petShopWithLowestPrice = null;
        double lowestPrice = Double.MAX_VALUE;

        for (PetShop petShop : petShops) {

            double preco = petShop.calcularPreco(data, caesGrandes, caesPequenos);
            //calcula se o proximo petshop tem preco menor que o petshop atual
            if (preco < lowestPrice || (preco == lowestPrice && petShopWithLowestPrice.getDistancia() > petShop.getDistancia())) {
                lowestPrice = preco;
                petShopWithLowestPrice = petShop;
            }
        }

        return petShopWithLowestPrice;
    }
    
}

package com.example.demo.repositories;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.example.demo.models.PetShop;

public interface PetShopRepository extends JpaRepository<PetShop, Long>, JpaSpecificationExecutor<PetShop> {
    
    
    
}  

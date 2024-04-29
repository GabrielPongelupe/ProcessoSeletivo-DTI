package com.example.demo.DTOs;

import com.example.demo.models.PetShop;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class PetShopReturn {
    private PetShop petShop;
    private Double value;
}

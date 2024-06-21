package com.example.warehouse.system.requestdto;

import java.util.List;

import com.example.warehouse.system.enums.MaterialTypes;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class StorageRequest {

    private String blockName;
    private String section;
    private double capacityInKg;
    private double lengthInMeters;
    private double breadthInMeters;
    private double heightInMeters;
    private double maxAdditionalWeight;
    private List<MaterialTypes> materialTypes;
    

}

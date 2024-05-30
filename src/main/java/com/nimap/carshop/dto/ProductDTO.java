package com.nimap.carshop.dto;
import com.nimap.carshop.model.Category;
import lombok.Data;

@Data
 public  class ProductDTO {

    private Long id;
    private String carName;
    private String carType;
    private String fueling;
    private double mileage;
    private double price;
   private Long categoryId;

}

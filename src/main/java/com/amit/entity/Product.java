package com.amit.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Negative;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import lombok.Data;

@Data
@Entity
@Table(name = "PRODUCT_DTLS")
public class Product {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer pid;
	
    @NotBlank(message="Character should be min=3 & max=10")
    @NotNull(message="Name is mandatory")
	private String name;
    
    @NotNull(message="Price is mandatory")
	private Double price;
    
    @NotNull(message="Price is mandatory")
	private Integer qty;
	

}

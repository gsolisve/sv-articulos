package com.sv.articulos.models;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
@Table(name = "item")
public class ItemModel {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name = "name")
	private String name;
	
	@Column(name = "quantity")
	private Double quantity;
	
	@Column(name = "price")
	private BigDecimal price;
	
	
	@ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_status",  nullable = false)
	private StatusModel status;
	
	@ManyToOne
	@JoinColumn(name = "id_category" , nullable = false )
	private CategoryModel category;
	
	@Column(name = "expiry_date")
	private LocalDateTime expireDate;
	
	@Column(name = "image")
	private String image;
	
	
}

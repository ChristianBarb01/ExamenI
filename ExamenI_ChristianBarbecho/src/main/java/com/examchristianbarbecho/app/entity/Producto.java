package com.examchristianbarbecho.app.entity;


import javax.persistence.Entity;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.Digits;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

import javax.validation.constraints.NotNull;

import lombok.Data;



@Entity
@Data
@Table(name="Producto",
uniqueConstraints = {
		@UniqueConstraint(columnNames = "codigo"),
})

public class Producto {

	@Id
	@Column(name="codigo")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long codigo;
	
	@Column(length = 100)
	@NotBlank(message = "El campo descripcion esta vacio")
	@NotNull
	private String descripcion;
	@NotNull
	@NotBlank(message = "El campo precio esta vacio")
	@DecimalMax(value = "0.0", inclusive = false)
    @Digits(integer=3, fraction=2)
	@Min(value=1, message="el valor debe ser mayor a cero")  
	private double precio;
	@NotNull
	@NotBlank(message = "El campo cantidad esta vacio")
	@Min(value=1, message="el valor debe ser mayor a cero")  
	private int cantidad;


	public long getCodigo() {
		return codigo;
	}

	public void setCodigo(long codigo) {
		this.codigo = codigo;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}
	
	
	
}
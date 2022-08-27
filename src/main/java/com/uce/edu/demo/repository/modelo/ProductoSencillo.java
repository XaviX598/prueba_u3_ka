package com.uce.edu.demo.repository.modelo;

import java.io.Serializable;

public class ProductoSencillo implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String codigo;
	private String nombre;
	private Integer stock;
	
	public ProductoSencillo() {
		// TODO Auto-generated constructor stub
	}

	

	

	public ProductoSencillo(String codigo, String nombre, Integer stock) {
		
		this.codigo = codigo;
		this.nombre = nombre;
		this.stock = stock;
	}





	@Override
	public String toString() {
		return "ProductoSencillo [codigo=" + codigo + ", nombre=" + nombre + ", stock=" + stock + "]";
	}

	//set y get
	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Integer getStock() {
		return stock;
	}

	public void setStock(Integer stock) {
		this.stock = stock;
	}
	
	
	
	
	

}

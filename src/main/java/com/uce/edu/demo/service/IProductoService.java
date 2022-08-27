package com.uce.edu.demo.service;

import com.uce.edu.demo.repository.modelo.Producto;
import com.uce.edu.demo.repository.modelo.ProductoSencillo;

public interface IProductoService {

	public void insertarProducto(Producto p);

	public void actualizar(Producto p);

	public Producto buscarCodigo(String codigo);
	
	
	
	public void ingresarProductosStock(Producto producto, Integer stock);
	
	public ProductoSencillo buscarStock(String codigo, String nombre, Integer stock);

}

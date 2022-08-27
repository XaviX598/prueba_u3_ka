package com.uce.edu.demo.repository;

import com.uce.edu.demo.repository.modelo.Producto;
import com.uce.edu.demo.repository.modelo.ProductoSencillo;

public interface IProductoRepository {
	
	public void insertarProducto(Producto p);
	
	public void actualizar(Producto p);
	
	public Producto buscarCodigo(String codigo);
	
	public ProductoSencillo buscarStock(String codigo, String nombre, Integer stock);

}

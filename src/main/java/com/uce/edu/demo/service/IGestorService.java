package com.uce.edu.demo.service;

import com.uce.edu.demo.repository.modelo.Producto;

public interface IGestorService {
	
	public void ingresarProductos(Producto p, Integer stock);

}

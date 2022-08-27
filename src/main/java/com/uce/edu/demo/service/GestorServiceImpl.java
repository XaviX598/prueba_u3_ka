package com.uce.edu.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uce.edu.demo.repository.modelo.Producto;
@Service
public class GestorServiceImpl implements IGestorService{
	
	@Autowired
	private IProductoService iProductoService;

	@Override
	public void ingresarProductos(Producto p, Integer stock) {
		// TODO Auto-generated method stub
		Producto prod = this.iProductoService.buscarCodigo(p.getNombre());
		if(prod != null) {
			prod.setStock(prod.getStock()+stock);
			this.iProductoService.insertarProducto(p);
			
		}else{
			p.setStock(stock);
			this.iProductoService.insertarProducto(p);
		}
	}

}

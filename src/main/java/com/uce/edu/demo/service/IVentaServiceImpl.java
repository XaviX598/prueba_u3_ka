package com.uce.edu.demo.service;

import java.util.List;

import com.uce.edu.demo.repository.modelo.ProductoSencillo;

public interface IVentaServiceImpl {
	
	public void realizarVenta(List<ProductoSencillo> listaProductos, String cedulaCliente, String numeroVenta);

}

package com.uce.edu.demo.service;

import javax.transaction.Transactional;
import javax.transaction.Transactional.TxType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uce.edu.demo.repository.IProductoRepository;
import com.uce.edu.demo.repository.modelo.Producto;
import com.uce.edu.demo.repository.modelo.ProductoSencillo;

@Service
public class ProductoServiceImpl implements IProductoService{

	@Autowired
	private IProductoRepository iProductoRepository;

	@Override
	@Transactional(value=TxType.REQUIRED)
	public void insertarProducto(Producto p) {
		// TODO Auto-generated method stub
		this.iProductoRepository.insertarProducto(p);
	}

	@Override
	@Transactional(value=TxType.REQUIRED)
	public void actualizar(Producto p) {
		// TODO Auto-generated method stub
		this.iProductoRepository.actualizar(p);
	}

	@Override
	@Transactional(value=TxType.REQUIRED)
	public Producto buscarCodigo(String codigo) {
		// TODO Auto-generated method stub
		return this.iProductoRepository.buscarCodigo(codigo);
	}

	@Override
	@Transactional(value=TxType.REQUIRED)
	public ProductoSencillo buscarStock(String codigo, String nombre, Integer stock) {
		// TODO Auto-generated method stub
		return this.iProductoRepository.buscarStock(codigo, nombre, stock);
	}

	@Override
	public void ingresarProductosStock(Producto producto, Integer stock) {
		// TODO Auto-generated method stub
		Producto p = this.buscarCodigo(producto.getCodigoBarras());
		Integer pstock = p.getStock();
		if (pstock == null) {
			producto.setStock(stock);
			this.insertarProducto(producto);
		} else {
			p.setStock(p.getStock() + stock);
			this.actualizar(producto);
		}
	}
	
	
}

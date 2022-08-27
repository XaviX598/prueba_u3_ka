package com.uce.edu.demo.service;

import java.util.List;

import javax.transaction.Transactional;
import javax.transaction.Transactional.TxType;

import org.springframework.stereotype.Service;

import com.uce.edu.demo.repository.modelo.ProductoSencillo;

@Service
public class VentaServiceImpl implements IVentaServiceImpl{

	@Override
	@Transactional(value=TxType.MANDATORY)
	public void realizarVenta(List<ProductoSencillo> listaProductos, String cedulaCliente, String numeroVenta) {
		// TODO Auto-generated method stub
		
	}

}

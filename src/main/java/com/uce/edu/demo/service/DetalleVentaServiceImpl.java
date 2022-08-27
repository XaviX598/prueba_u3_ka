package com.uce.edu.demo.service;

import java.time.LocalDateTime;

import javax.transaction.Transactional;
import javax.transaction.Transactional.TxType;

import org.springframework.stereotype.Service;

@Service
public class DetalleVentaServiceImpl implements IDetalleVentaService{

	@Override
	@Transactional(value=TxType.REQUIRED)
	public void reporte(LocalDateTime fechaVenta, String categoria, Integer cantidad) {
		// TODO Auto-generated method stub
		
	}

}

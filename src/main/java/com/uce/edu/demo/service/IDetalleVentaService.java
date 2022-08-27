package com.uce.edu.demo.service;

import java.time.LocalDateTime;

public interface IDetalleVentaService {
	
	public void reporte(LocalDateTime fechaVenta, String categoria, Integer cantidad);

}

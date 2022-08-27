package com.uce.edu.demo;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.uce.edu.demo.repository.modelo.DetalleVenta;
import com.uce.edu.demo.repository.modelo.Producto;
import com.uce.edu.demo.repository.modelo.ProductoSencillo;
import com.uce.edu.demo.repository.modelo.Venta;
import com.uce.edu.demo.service.IDetalleVentaService;
import com.uce.edu.demo.service.IGestorService;
import com.uce.edu.demo.service.IProductoService;
import com.uce.edu.demo.service.IVentaServiceImpl;

@SpringBootApplication
public class PruebaU3KaApplication implements CommandLineRunner{
	
	private static final Logger log = Logger.getRootLogger();
	
	@Autowired
	private IProductoService iProductoService;
	
	@Autowired
	private IVentaServiceImpl iVentaServiceImpl;
	
	@Autowired
	private IDetalleVentaService detalleVentaService;
	
	@Autowired
	private IGestorService iGestorService;

	public static void main(String[] args) {
		SpringApplication.run(PruebaU3KaApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		
		//insertar al menos 1 producto
		Producto p = new Producto();
		p.setNombre("Doritos");
		p.setPrecio(new BigDecimal(1));
		p.setStock(100);
		p.setCodigoBarras("45654654");
		p.setCategoria("Carbohidratos");
		
		this.iProductoService.insertarProducto(p);
		
		Producto p1 = new Producto();
		p1.setNombre("Leche");
		p1.setPrecio(new BigDecimal(1.20));
		p1.setStock(30);
		p1.setCodigoBarras("554654156");
		p1.setCategoria("Lacteos");
		//this.iProductoService.ingresarProductosStock(p1, p1.getStock());
		//this.iGestorService.ingresarProductos(p1, p1.getStock());
		this.iProductoService.insertarProducto(p1);
		
		//venta con un producto
		Venta v = new Venta();
		v.setTotalVenta(new BigDecimal(20));
		v.setFecha(LocalDateTime.now());
		v.setCedulaCliente("4445489489");
		
		List<DetalleVenta> dv = new ArrayList<>();
		
		DetalleVenta d = new DetalleVenta();
		d.setVenta(v);
		d.setProducto(p);
		d.setPrecioUnitario(new BigDecimal(1));
		d.setCantidad(5);
		
		dv.add(d);
		
		v.setDetalles(dv);
		p.setDetalles(dv);
		
		List<ProductoSencillo> list = new ArrayList<>();
		ProductoSencillo ps = new ProductoSencillo();
		ps.setStock(100);
		ps.setNombre("Arina");
		ps.setCodigo("54654654");
		list.add(ps);
		
		//this.iVentaServiceImpl.realizarVenta(list, "465454", "1");
		
		
		//imprimir un producto por su codigo de barras
		log.info("Producto por codigo es: "+ this.iProductoService.buscarCodigo("45654654"));
		
		//Consultar Stock
		//log.info("El stock del productpo es" + this.iProductoService.buscarStock(p.getCodigoBarras(), p.getNombre(),p.getStock()));
		
	}

}

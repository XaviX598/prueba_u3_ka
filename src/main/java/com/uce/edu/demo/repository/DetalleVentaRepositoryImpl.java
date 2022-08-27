package com.uce.edu.demo.repository;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import javax.transaction.Transactional.TxType;

import org.springframework.stereotype.Repository;

import com.uce.edu.demo.repository.modelo.DetalleVenta;

@Repository
@Transactional
public class DetalleVentaRepositoryImpl implements IDetalleVentaRepository{
	
	@PersistenceContext
	private EntityManager entityManager;

	@Override
	@Transactional(value=TxType.REQUIRED)
	public List<DetalleVenta> buscarFecha(LocalDateTime fecha) {
		// TODO Auto-generated method stub
		TypedQuery<DetalleVenta> myQuery = this.entityManager.createQuery("SELECT d FROM DetalleVenta d WHERE d.fecha = :datoFecha", DetalleVenta.class);
		myQuery.setParameter("datoFecha", fecha);
		return myQuery.getResultList();
	}

}

package com.uce.edu.demo.repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import javax.transaction.Transactional;
import javax.transaction.Transactional.TxType;

import org.springframework.stereotype.Repository;

import com.uce.edu.demo.repository.modelo.Producto;
import com.uce.edu.demo.repository.modelo.ProductoSencillo;

@Repository
@Transactional
public class ProductoRepositoryImpl implements IProductoRepository {

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	@Transactional(value = TxType.MANDATORY)
	public void insertarProducto(Producto p) {
		// TODO Auto-generated method stub
		this.entityManager.persist(p);
	}

	@Override
	@Transactional(value = TxType.MANDATORY)
	public void actualizar(Producto p) {
		// TODO Auto-generated method stub
		this.entityManager.merge(p);
	}

	@Override
	@Transactional(value = TxType.NOT_SUPPORTED)
	public Producto buscarCodigo(String codigo) {
		// TODO Auto-generated method stub
		TypedQuery<Producto> myQuery = this.entityManager
				.createQuery("SELECT p FROM Producto p WHERE p.codigoBarras = :datoCodigo", Producto.class);
		myQuery.setParameter("datoCodigo", codigo);
		return myQuery.getSingleResult();
	}

	@Override
	public ProductoSencillo buscarStock(String codigo, String nombre, Integer stock) {
		CriteriaBuilder myBuilder = this.entityManager.getCriteriaBuilder();

		CriteriaQuery<ProductoSencillo> myQuery = myBuilder.createQuery(ProductoSencillo.class);

		Root<ProductoSencillo> myTabla = myQuery.from(ProductoSencillo.class);

		Predicate predCogidoBarras = myBuilder.equal(myTabla.get("codigoBarras"), codigo);
		Predicate predNombre = myBuilder.equal(myTabla.get("nombre"), nombre);
		Predicate predStock = myBuilder.equal(myTabla.get("stock"), stock);

		Predicate miPredFinal = myBuilder.and(predCogidoBarras, predNombre, predStock);

		CriteriaQuery<ProductoSencillo> myQueryCompleto = myQuery.select(myTabla).where(miPredFinal);

		TypedQuery<ProductoSencillo> myQueryFinal = this.entityManager.createQuery(myQueryCompleto);

		return myQueryFinal.getSingleResult();
	}

}

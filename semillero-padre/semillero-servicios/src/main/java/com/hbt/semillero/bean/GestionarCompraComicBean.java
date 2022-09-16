package com.hbt.semillero.bean;

import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.hbt.semillero.dtos.CompraComicDTO;
import com.hbt.semillero.poo.interfaces.IGestionarCompraComic;

@Stateless
@TransactionManagement(TransactionManagementType.CONTAINER)
public class GestionarCompraComicBean implements IGestionarCompraComic {
	
	@PersistenceContext
	private EntityManager em;
	
	@Override
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public CompraComicDTO compraComic(Long idComic, Long cantidad) {
		CompraComicDTO compraComicDTO = new CompraComicDTO();
		Object obj = new Object();
		try {
			String sqlConsultaComic = "SELECT c.nombre, c.estadoEnum, c.cantidad "
					+ " FROM Comic c "
					+ " WHERE c.id = :idComic ";
			Query queryConsultaComic = em.createQuery(sqlConsultaComic);
			queryConsultaComic.setParameter("idComic", idComic);
			//queryConsultaComic.getSingleResult();
			
			String sqlCompraComic = "UPDATE Comic "
					+ "SET cantidad = :cantidad"
					+ " WHERE id = :idComic ";
			Query queryCompraComic = em.createQuery(sqlCompraComic);
			queryCompraComic.setParameter("idComic", idComic);
			queryCompraComic.setParameter("cantidad", cantidad);
			queryCompraComic.executeUpdate();
			compraComicDTO.setExitoso(true);
			compraComicDTO.setMensajeEjecucion("La compra del comic x fue exitosa");
		} catch (Exception e) {
			return null;
		}
		return compraComicDTO;
	}

}

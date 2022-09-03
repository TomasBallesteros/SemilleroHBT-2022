package com.hbt.semillero.bean;

import java.util.List;

import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.apache.log4j.Logger;

import com.hbt.semillero.dtos.ConsultaNombreComicDTO;
import com.hbt.semillero.entity.Comic;
import com.hbt.semillero.poo.interfaces.IConsultarComicLocal;

/**
 * <b>Descripción:<b> Clase que determina
 * <b>Caso de Uso:<b> 
 * @author thoma
 * @version 
 */

@Stateless
@TransactionManagement(TransactionManagementType.CONTAINER)
public class ConsultarComicBean implements IConsultarComicLocal {
	
private final static Logger LOGGER = Logger.getLogger(ConsultarComicBean.class);
	
	@PersistenceContext
	private EntityManager em;
	
	@Override
	@TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
	@SuppressWarnings("unchecked")
	public ConsultaNombreComicDTO consultarNombreComic(short lengthComic) {
		LOGGER.info("Inicia ejecucion consultarNombreComic() ");
		ConsultaNombreComicDTO dto = new ConsultaNombreComicDTO();
		
		if(lengthComic > 50) {
			
			LOGGER.error("La longitud máxima permitida es de 50 caracteres");
			dto.setExitoso(false);
			dto.setMensajeEjecucion("La longitud maxima permitida es de 50 caracteres");
			return dto;
			
		} else {
			
			String consultaNombreNoSuperaTamanioComic = "SELECT c.nombre"
					+ " FROM Comic c"
					+ " WHERE LENGTH(c.nombre) < :lengthComic";
			String consultaNombreSuperaTamanioComic = "SELECT c.nombre"
					+ " FROM Comic c"
					+ " WHERE LENGTH(c.nombre) >= :lengthComic";
			
			try {
				Query queryConsultaNombreNoSuperaTamanioComic = em.createQuery(consultaNombreNoSuperaTamanioComic);
				queryConsultaNombreNoSuperaTamanioComic.setParameter("lengthComic", (int) lengthComic);
				List<Comic> listNombresNoSuperaTamanioComics = queryConsultaNombreNoSuperaTamanioComic.getResultList();
				
				Query queryConsultaNombreSuperaTamanioComic = em.createQuery(consultaNombreSuperaTamanioComic);
				queryConsultaNombreSuperaTamanioComic.setParameter("lengthComic", (int) lengthComic);
				List<Comic> listNombresSuperaTamanioComics = queryConsultaNombreSuperaTamanioComic.getResultList();
				
				dto.setComicsNoSuperanTamanio(listNombresNoSuperaTamanioComics.toString());
				dto.setComicsSuperanTamanio(listNombresSuperaTamanioComics.toString());
				dto.setExitoso(true);
				dto.setMensajeEjecucion("Comics procesados exitosamente");
				
			
			} catch (Exception e) {
				dto.setExitoso(false);
				dto.setMensajeEjecucion("Se ha presentado un error tecnico" + e.getMessage());
				LOGGER.info("Se ha presentado un error tecnico" + e.getMessage());
			}
			
			LOGGER.info("Finaliza ejecucion consultarNombreComic() ");
			
			return dto;
			
		}
		
	}
	
}
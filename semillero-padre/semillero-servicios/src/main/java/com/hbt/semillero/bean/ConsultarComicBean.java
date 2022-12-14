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
 * <b>Descripción:<b> Clase Bean que define la interfaz IConsultarComicLocal
 * <b>Caso de Uso:<b> Semillero2022
 * @author Tomas Ballesteros
 * @version 
 */

@Stateless
@TransactionManagement(TransactionManagementType.CONTAINER)
public class ConsultarComicBean implements IConsultarComicLocal {
	
	/**
	 * Constante que contendra el log de la clase ConsultarComicBean
	 */
	private final static Logger LOGGER = Logger.getLogger(ConsultarComicBean.class);
	
	/**
	 * Entity manager crado a partir del PersistenceContext
	 */
	@PersistenceContext
	private EntityManager em;
	
	/**
	 * Metodo encargado de retornar un objeto que contiene los nombres de los comics clasififcados en 2 listas según el length del que ocupan los caracteres en el campo
	 * @see com.hbt.semillero.poo.interfaces.IConsultarComicLocal#consultarNombreComic(short)
	 */
	@Override
	@TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
	@SuppressWarnings("unchecked")
	public ConsultaNombreComicDTO consultarNombreComic(Short lengthComic) {
		
		LOGGER.info("Inicia ejecucion consultarNombreComic() ");
		
		ConsultaNombreComicDTO dto = new ConsultaNombreComicDTO();
		
		/**
		 * Validamos que el parámetro lengthComic no sea mayor a 50, en caso de cumplirse la condición se crea una excepción
		 */
		if(lengthComic > 50) {
			
			LOGGER.error("La longitud máxima permitida es de 50 caracteres");
			dto.setExitoso(false);
			dto.setMensajeEjecucion("La longitud maxima permitida es de 50 caracteres");
			return dto;
			
		} else {
		
			/**
			 * Creamos 2 variables de instancia para ejecutar 2 consultas de tipo JPQL
			 */
			String consultaNombreNoSuperaTamanioComic = "SELECT c.nombre"
					+ " FROM Comic c"
					+ " WHERE LENGTH(c.nombre) < :lengthComic";
			String consultaNombreSuperaTamanioComic = "SELECT c.nombre"
					+ " FROM Comic c"
					+ " WHERE LENGTH(c.nombre) >= :lengthComic";
			
			try {
				Query queryConsultaNombreNoSuperaTamanioComic = em.createQuery(consultaNombreNoSuperaTamanioComic);
				queryConsultaNombreNoSuperaTamanioComic.setParameter("lengthComic", lengthComic.intValue());
				List<Comic> listNombresNoSuperaTamanioComics = queryConsultaNombreNoSuperaTamanioComic.getResultList();
				
				Query queryConsultaNombreSuperaTamanioComic = em.createQuery(consultaNombreSuperaTamanioComic);
				queryConsultaNombreSuperaTamanioComic.setParameter("lengthComic", lengthComic.intValue());
				List<Comic> listNombresSuperaTamanioComics = queryConsultaNombreSuperaTamanioComic.getResultList();
				
				/**
				 * Se pasa lista al campo destinado en el objeto dto
				 */
				dto.setComicsNoSuperanTamanio(listNombresNoSuperaTamanioComics.toString());
				dto.setComicsSuperanTamanio(listNombresSuperaTamanioComics.toString());
				dto.setExitoso(true);
				dto.setMensajeEjecucion("Comics procesados exitosamente");
				
			} catch (Exception e) {
				dto.setExitoso(false);
				dto.setMensajeEjecucion("Se ha presentado un error tecnico " + e.getMessage());
				LOGGER.info("Se ha presentado un error tecnico " + e.getMessage());
			}
			
			LOGGER.info("Finaliza ejecucion consultarNombreComic() ");
			
			/**
			 * Retornamos el objeto dto
			 */
			return dto;
			
		}
	}
}

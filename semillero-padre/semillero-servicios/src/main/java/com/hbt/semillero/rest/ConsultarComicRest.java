package com.hbt.semillero.rest;

import javax.ejb.EJB;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import com.hbt.semillero.dtos.ConsultaNombreComicDTO;
import com.hbt.semillero.poo.interfaces.IConsultarComicLocal;

/**
 * <b>Descripción:<b> Clase que determina
 * <b>Caso de Uso:<b> 
 * @author Tomas Balleteros
 * @version 
 */

@Path("/consultarComicRest")
public class ConsultarComicRest {
	
	@EJB
	private IConsultarComicLocal consultarNombreLocal;
	
	/**
	 * 
	 * Metodo encargado de mostrar el resultado de la consulta de los comics clasififcados en 2 listas según el length del campo nombre
	 * <b>Caso de Uso</b> Semillero2022
	 * @author Tomas Ballesteros
	 * 
	 * @param lengthComic
	 * @return
	 * @throws Exception
	 */
	@GET
	@Path("/consultarComicTamanioNombre")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public ConsultaNombreComicDTO consultarNombreComic(@QueryParam("lengthComic") Short lengthComic) {
		return this.consultarNombreLocal.consultarNombreComic(lengthComic) ;
	}
	
}

package com.hbt.semillero.rest;

import javax.ejb.EJB;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import com.hbt.semillero.dtos.CompraComicDTO;
import com.hbt.semillero.poo.interfaces.IGestionarCompraComic;

@Path("/gestionarCompraComicRest")
public class GestionarCompraComicRest {
	
	@EJB
	private IGestionarCompraComic gestionarCompraComic;

	@POST
	@Path("/comprarComic")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public CompraComicDTO compraComic(@QueryParam("idComic") Long idComic, @QueryParam("cantidad") Long cantidad) {
		return this.gestionarCompraComic.compraComic(idComic, cantidad);
	}
}

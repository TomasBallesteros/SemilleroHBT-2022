package com.hbt.semillero.dtos;

import java.io.Serializable;

import com.hbt.semillero.enums.EstadoEnum;
import com.hbt.semillero.util.JsonUtils;

import lombok.Data;

/**
 * <b>Descripción:<b> Clase que determina
 * <b>Caso de Uso:<b> 
 * @author thoma
 * @version 
 */
@Data
public class CompraComicDTO extends ResultadoDTO implements Serializable {
	/**
	 * Atributo que determina  
	 */
	private static final long serialVersionUID = 1L;
	private String nombre;
	private EstadoEnum estadoEnum;
	private Long cantidad;
	
	/**
	 * Método encargado de convertir los datos recibidos en JSON al tipo ComicDTO.
	 * <b>Caso de Uso:</b>
	 * 
	 * @param arg Cadena que representa el objeto complejo JSON.
	 * @return Instancia con los datos recibidos.
	 */
	public static ComicDTO valueOf(String arg) {
		return JsonUtils.valueOf(arg, ComicDTO.class);
	}

	/**
	 * Método encargado de convertir los datos recibidos en ComicDTO al JSON
	 * esperado
	 * 
	 * @param dto DTO
	 * 
	 * @return Json
	 */
	@Override
	public String toString() {
		return JsonUtils.toStringJson(this);
	}
}

package com.hbt.semillero.dtos;

import java.io.Serializable;
import java.util.List;

import com.hbt.semillero.entity.Comic;
import com.hbt.semillero.util.JsonUtils;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * <b>Descripción:<b> Clase que determina
 * <b>Caso de Uso:<b> 
 * @author thoma
 * @version 
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ConsultaNombreComicDTO extends ResultadoDTO implements Serializable {
	
	/**
	 * Atributo que determina  
	 */
	private static final long serialVersionUID = 1L;
	private String comicsNoSuperanTamanio;
	private String comicsSuperanTamanio;

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

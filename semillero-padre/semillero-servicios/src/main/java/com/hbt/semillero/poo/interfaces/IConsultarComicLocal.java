package com.hbt.semillero.poo.interfaces;

import javax.ejb.Local;

import com.hbt.semillero.dtos.ConsultaNombreComicDTO;

/**
 * <b>Descripción:<b> Clase que determina
 * <b>Caso de Uso:<b> 
 * @author thoma
 * @version 
 */

@Local
public interface IConsultarComicLocal {
	
	public ConsultaNombreComicDTO consultarNombreComic(short lengthComic);
	
}

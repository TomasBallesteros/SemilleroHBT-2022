package com.hbt.semillero.poo.interfaces;

import java.util.List;

import javax.ejb.Local;

import com.hbt.semillero.dtos.ComicDTO;
import com.hbt.semillero.dtos.ConsultaNombrePrecioComicDTO;
import com.hbt.semillero.dtos.EliminarComicDTO;
import com.hbt.semillero.dtos.ObjetoListaDTO;
import com.hbt.semillero.dtos.ResultadoDTO;

@Local
public interface IGestionarComicLocal {

	public ConsultaNombrePrecioComicDTO consultarNombrePrecioComic(Long idComic);
	
	public List<ComicDTO> obtenerComics();
	
	public List<ObjetoListaDTO> obtenerTematicaEnum();
	
	public EliminarComicDTO eliminarComic(Long idComic);
	
	public ResultadoDTO crearComic(ComicDTO comicDTO) throws Exception;
	
}
package com.hbt.semillero.poo.interfaces;

import javax.ejb.Local;

import com.hbt.semillero.dtos.CompraComicDTO;

@Local
public interface IGestionarCompraComic {
	
	public CompraComicDTO compraComic(Long idComic, Long cantidad);
	
}

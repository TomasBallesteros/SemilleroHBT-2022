/**
 * TematicaEnum.java
 */
package com.hbt.semillero.emuns;

/**
 * <b>Descripción:<b> Clase que contiene la tematica de la tabla Comic en la BD de semillero
 * <b>Caso de Uso:<b> Semillero2022
 * @author Tomas Ballesteros
 * @version 1.0
 */
public enum TematicaEnum {
	AVENTURAS("enum.tematica.aventuras"),
	BELICO("enum.tematica.belico"),
	HUMORISTICO("enum.tematica.humoristico"),
	DEPORTIVO("enum.tematica.deportivo"),
	FANTASTICO("enum.tematica.fantastico"),
	CIENCIA_FICCION("enum.tematica.ciencia_ficcion"),
	HISTORICO("enum.tematica.historico"),
	HORROR("enum.tematica.horror"),
	
	;
	
	private String etiqueta;
	
	TematicaEnum(String etiqueta){
		this.etiqueta = etiqueta;
	}
	
	public String getEtiqueta() {
		return etiqueta;
	}
}
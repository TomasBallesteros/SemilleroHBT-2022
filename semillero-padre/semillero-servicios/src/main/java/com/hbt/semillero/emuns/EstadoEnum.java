/**
 * estadoEnum.java
 */
package com.hbt.semillero.emuns;

/**
 * <b>Descripción:<b> Clase que determina la estado del Comic en la DB de semillero
 * <b>Caso de Uso:<b> Semillero2022
 * @author Tomas Ballesteros
 * @version 1.0
 */
public enum EstadoEnum {
	ACTIVO("Activo", 1),
	INACTIVO("Inactivo", 2),
	
	;
	/**
	 * 
	 */
	private String estado;
	
	/**
	 * 
	 */
	private int identificador;
	
	/**
	 * 
	 * Constructor de la clase.
	 * @param estado
	 * @param identificador
	 */
	EstadoEnum(String estado, int identificador){
		this.estado = estado;
		this.identificador = identificador;
	}
	
	/**
	 * Metodo encargado de retornar el valor del atributo estado
	 * @return El editorial asociado a la clase
	 */
	public String getEstado() {
		return estado;
	}
	
	/**
	 * Metodo encargado de retornar el valor del atributo identificador
	 * @return El identificador asociado a la clase
	 */
	public int getIdentificador() {
		return identificador;
	}
}
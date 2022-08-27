/**
 * CreacionComicTest.java
 */
package com.hbt.semillero.test;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;
import org.junit.Before;
import org.junit.Test;
import com.hbt.semillero.emuns.EstadoEnum;
import com.hbt.semillero.entity.Comic;

/**
 * <b>Descripción:<b> Clase que determina
 * <b>Caso de Uso:<b> Semillero2022
 * @author Tomas Ballesteros
 * @version 1.0
 */
public class CreacionComicTest {
	
	private final static Logger LOGGER = Logger.getLogger(CreacionComicTest.class);
	
	@Before
	public void inicializar() {
		BasicConfigurator.configure();
		LOGGER.info("Inicialización de Configuracion de Log4j.");
	}
	
	@Test
	public void whenCreateComicGivenSuccesThenOK() {
		LOGGER.info("Inicia ejecucion del test whenCreateComicGivenSuccesThenOK()");
		Comic comics = new Comic();
		comics.AgregarComics(10);
		
		LOGGER.info("Finaliza ejecucion del test whenCreateComicGivenSuccesThenOK()");
	}
	
	@Test
	public void whenDeterminarEstadosGivenTrueThenExito() throws Exception {
		LOGGER.info("Inicia ejecucion del test whenDeterminarTipoVehiculoGivenTrueThenExito()");
		Comic comics = new Comic();
		comics.AgregarComics(10);
		comics.setEstado(EstadoEnum.ACTIVO);
		
		boolean respuesta = comics.enumerarTiposEstados(comics.getEstado());
		assertTrue(respuesta);
		LOGGER.info("Finaliza ejecucion del test whenDeterminarTipoVehiculoGivenTrueThenExito()");
	}
	
	/*@Test
	public void whenDeterminarEstadosGivenTrueThenFallido() {
		LOGGER.info("Inicia ejecucion del test whenDeterminarTipoVehiculoGivenTrueThenExito()");
		Comic comics = new Comic();
		//comics.AgregarComics(10);
		comics.setEstado(EstadoEnum.INACTIVO);
		
		Exception exception = assertThrows(Exception.class, () -> {
			comics.determinarTipoVehiculo(comics.getTipo());
		});
		assertNotNull(exception);
		LOGGER.info("Finaliza ejecucion del test whenDeterminarTipoVehiculoGivenTrueThenExito()");
	}*/
}
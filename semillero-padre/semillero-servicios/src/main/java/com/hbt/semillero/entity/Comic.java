/**
 * Comic.java
 */
package com.hbt.semillero.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.apache.log4j.Logger;

import com.hbt.semillero.emuns.EstadoEnum;
import com.hbt.semillero.emuns.TematicaEnum;

/**
 * <b>Descripción:<b> Clase que contiene la informacion de la tabla Comic en la BD de semillero
 * <b>Caso de Uso:<b> Semillero2022
 * @author Tomas Ballesteros
 * @version 1.0
 */
@Entity
@Table(name="COMIC")
public class Comic implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 8609704051595047311L;
	
	/**
	 * 
	 */
	private List<Comic> listaComics = new ArrayList<>();
	
	/**
	 * 
	 */
	private final static Logger LOGGER = Logger.getLogger(Comic.class);
	
	@Id
	@Column(name="SCID")
	@SequenceGenerator(allocationSize = 1, name = "COMIC_SCID_GENERATOR", sequenceName = "SEQ_COMIC")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "COMIC_SCID_GENERATOR")
	private Long id;
	
	/**
	 * Atributo que contiene datos de la columna nombre en la tabla Comic de la DB semillero
	 */
	@Column(name="SCNOMBRE")
	private String nombre;
	
	@Column(name="SCEDITORIAL")
	private String editorial;
	
	@Column(name="SCTEMATICA")
	private TematicaEnum tematica;
	
	@Column(name="SCCOLECCION")
	private String coleccion;
	
	@Column(name="SCNUMEROPAGINAS")
	private short numeroPaginas;
	
	@Column(name="SCPRECIO")
	private BigDecimal precio;
	
	@Column(name="SCAUTORES")
	private String autores;
	
	@Column(name="SCCOLOR")
	private Boolean color;
	
	@Column(name="SCFECHA_VENTA")
	private LocalDate fechaVenta;

	@Column(name="SCESTADO")
	private EstadoEnum estado;
	
	@Column(name="SCCANTIDAD")
	private short cantidad;
	
	/**
	 * 
	 * Constructor de la clase.
	 */
	public Comic() {
	}
	
	/**
	 * 
	 * Constructor de la clase.
	 * @param estado
	 */
	public Comic(EstadoEnum estado) {
		this.estado = estado;
	}
	
	/**
	 * 
	 * Constructor de la clase.
	 * @param id
	 * @param nombre
	 * @param editorial
	 * @param tematica
	 * @param coleccion
	 * @param numeroPaginas
	 * @param precio
	 * @param autores
	 * @param color
	 * @param fechaVenta
	 * @param estado
	 * @param cantidad
	 */
	public Comic(Long id, String nombre, String editorial, TematicaEnum tematica, String coleccion, short numeroPaginas, BigDecimal precio, String autores, Boolean color, LocalDate fechaVenta, EstadoEnum estado, short cantidad) {
		this.id = id;
		this.nombre = nombre;
		this.editorial = editorial;
		this.tematica = tematica;
		this.coleccion = coleccion;
		this.numeroPaginas = numeroPaginas;
		this.precio = precio;
		this.autores = autores;
		this.color = color;
		this.fechaVenta = fechaVenta;
		this.estado = estado;
		this.cantidad = cantidad;
	}



	/**
	 * Metodo encargado de retornar el valor del atributo id
	 * @return El id asociado a la clase
	 */
	public Long getId() {
		return id;
	}

	/**
	 * Metodo encargado de modificar el valor del atributo id
	 * @param id El nuevo id a modificar.
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * Metodo encargado de retornar el valor del atributo nombre
	 * @return El nombre asociado a la clase
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * Metodo encargado de modificar el valor del atributo nombre
	 * @param nombre El nuevo nombre a modificar.
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	/**
	 * Metodo encargado de retornar el valor del atributo editorial
	 * @return El editorial asociado a la clase
	 */
	public String getEditorial() {
		return editorial;
	}

	/**
	 * Metodo encargado de modificar el valor del atributo editorial
	 * @param editorial El nuevo editorial a modificar.
	 */
	public void setEditorial(String editorial) {
		this.editorial = editorial;
	}

	/**
	 * Metodo encargado de retornar el valor del atributo tematica
	 * @return El tematica asociado a la clase
	 */
	public TematicaEnum getTematica() {
		return tematica;
	}

	/**
	 * Metodo encargado de modificar el valor del atributo tematica
	 * @param tematica El nuevo tematica a modificar.
	 */
	public void setTematica(TematicaEnum tematica) {
		this.tematica = tematica;
	}

	/**
	 * Metodo encargado de retornar el valor del atributo coleccion
	 * @return El coleccion asociado a la clase
	 */
	public String getColeccion() {
		return coleccion;
	}

	/**
	 * Metodo encargado de modificar el valor del atributo coleccion
	 * @param coleccion El nuevo coleccion a modificar.
	 */
	public void setColeccion(String coleccion) {
		this.coleccion = coleccion;
	}

	/**
	 * Metodo encargado de retornar el valor del atributo numeroPaginas
	 * @return El numeroPaginas asociado a la clase
	 */
	public short getNumeroPaginas() {
		return numeroPaginas;
	}

	/**
	 * Metodo encargado de modificar el valor del atributo numeroPaginas
	 * @param numeroPaginas El nuevo numeroPaginas a modificar.
	 */
	public void setNumeroPaginas(short numeroPaginas) {
		this.numeroPaginas = numeroPaginas;
	}

	/**
	 * Metodo encargado de retornar el valor del atributo precio
	 * @return El precio asociado a la clase
	 */
	public BigDecimal getPrecio() {
		return precio;
	}

	/**
	 * Metodo encargado de modificar el valor del atributo precio
	 * @param precio El nuevo precio a modificar.
	 */
	public void setPrecio(BigDecimal precio) {
		this.precio = precio;
	}

	/**
	 * Metodo encargado de retornar el valor del atributo autores
	 * @return El autores asociado a la clase
	 */
	public String getAutores() {
		return autores;
	}

	/**
	 * Metodo encargado de modificar el valor del atributo autores
	 * @param autores El nuevo autores a modificar.
	 */
	public void setAutores(String autores) {
		this.autores = autores;
	}

	/**
	 * Metodo encargado de retornar el valor del atributo color
	 * @return El color asociado a la clase
	 */
	public Boolean getColor() {
		return color;
	}

	/**
	 * Metodo encargado de modificar el valor del atributo color
	 * @param color El nuevo color a modificar.
	 */
	public void setColor(Boolean color) {
		this.color = color;
	}

	/**
	 * Metodo encargado de retornar el valor del atributo fechaVenta
	 * @return El fechaVenta asociado a la clase
	 */
	public LocalDate getFechaVenta() {
		return fechaVenta;
	}

	/**
	 * Metodo encargado de modificar el valor del atributo fechaVenta
	 * @param fechaVenta El nuevo fechaVenta a modificar.
	 */
	public void setFechaVenta(LocalDate fechaVenta) {
		this.fechaVenta = fechaVenta;
	}

	/**
	 * Metodo encargado de retornar el valor del atributo estado
	 * @return El estado asociado a la clase
	 */
	public EstadoEnum getEstado() {
		return estado;
	}

	/**
	 * Metodo encargado de modificar el valor del atributo estado
	 * @param estado El nuevo estado a modificar.
	 */
	public void setEstado(EstadoEnum estado) {
		this.estado = estado;
	}

	/**
	 * Metodo encargado de retornar el valor del atributo cantidad
	 * @return El cantidad asociado a la clase
	 */
	public short getCantidad() {
		return cantidad;
	}

	/**
	 * Metodo encargado de modificar el valor del atributo cantidad
	 * @param cantidad El nuevo cantidad a modificar.
	 */
	public void setCantidad(short cantidad) {
		this.cantidad = cantidad;
	}
	
	/** 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Comic [id=" + id + ", nombre=" + nombre + ", editorial=" + editorial + ", tematica=" + tematica
				+ ", coleccion=" + coleccion + ", numeroPaginas=" + numeroPaginas + ", precio=" + precio + ", autores="
				+ autores + ", color=" + color + ", fechaVenta=" + fechaVenta + ", estado=" + estado + ", cantidad="
				+ cantidad + "]";
	}
	
	/**
	 * 
	 * Metodo encargado de 
	 * <b>Caso de Uso</b>
	 * @author Tomas Ballesteros
	 * 
	 * @param estadoEnum
	 * @return
	 * @throws Exception
	 */
	//@Override
	public boolean enumerarTiposEstados(EstadoEnum estadoEnum) throws Exception{
		
		List<String> activos = new ArrayList<>();
		
		Comic busquedaActivo = new Comic(EstadoEnum.ACTIVO);
		Comic busquedaInactivo = new Comic(EstadoEnum.INACTIVO);
		
		int activosCantidad = 0;
		int inactivosCantidad = 0;
		
		for(int i=0;i<listaComics.size();i++) {
			Comic comics = listaComics.get(i);
			if(comics.getEstado().equals(busquedaActivo.getEstado())) {
				activosCantidad++;
			}else if(comics.getEstado().equals(busquedaInactivo.getEstado())) {
				inactivosCantidad++;
				activos.add(comics.getNombre());
			}
		}
		
		if(EstadoEnum.ACTIVO.getIdentificador()==estado.getIdentificador()) {
			System.out.println("Se ha detectado que de "  + activos.size() +  " comics se encontraron que " + activosCantidad + "  se encuentran activos y " + inactivosCantidad + " inactivos. Los comics inactivos son: " + activos);
			return true;
		}else {
			//LOGGER.error("ERROR: El listado de Comics se encuentra vacio");
			throw new Exception("ERROR: El listado de Comics se encuentra vacio");
		}
		
	}

	/**
	 * 	
	 * Metodo encargado de 
	 * <b>Caso de Uso</b>
	 * @author thoma
	 * 
	 * @param cantidad
	 */
	public void AgregarComics(int cantidad) {
		
		Long id = 0L;
		Comic comic = null;
		
		for(int i=0;i<cantidad;i++) {
			
			id++;
			comic = new Comic(id, "Comic"+id, "Editorial"+id, TematicaEnum.AVENTURAS, "Coleccion"+id, (short)100, new BigDecimal(2500), "Autor"+id, new Boolean(true), LocalDate.now(), EstadoEnum.ACTIVO, (short)10);
			
			if(i%2==0) {
				comic.setEstado(EstadoEnum.INACTIVO);
				listaComics.add(comic);
			}else {
				listaComics.add(comic);
			}
			
		}
		
		System.out.println(ComicsInactivos());
		ComicsActivos();
		
	}
	
	/**
	 * 
	 * Metodo encargado de 
	 * <b>Caso de Uso</b>
	 * @author thoma
	 * 
	 * @return
	 */
	private List<Comic> ComicsInactivos() {
		
		List<Comic> activos = new ArrayList<>();
		
		Comic busqueda = new Comic(EstadoEnum.INACTIVO);
		
		for(int i=0;i<listaComics.size();i++) {
			Comic comics = listaComics.get(i);
			if(comics.getEstado().equals(busqueda.getEstado())) {
				//System.out.println("COMIC_INACTIVO: " + comics);
				activos.add(comics);
			}
		}
		
		return activos;
		
	}
	
	private List<Comic> ComicsActivos() {
		
		List<Comic> activos = new ArrayList<>();
		
		Comic busqueda = new Comic(EstadoEnum.ACTIVO);
		
		for(int i=0;i<listaComics.size();i++) {
			Comic comics = listaComics.get(i);
			if(comics.getEstado().equals(busqueda.getEstado())) {
				System.out.println("COMIC_ACTIVO: " + comics);
				activos.add(comics);
			}
		}
		
		return activos;
		
	}
	
	
}
package co.com.maxipollo.dto;

import java.util.Date;

/**
 * Clase dto para los datos de las reservaciones
 * @author Johan Martinez & Daniel Loaiza
 *
 */
public class Reservacion {
	
	/**
	 * Identificador de la reservaci�n en el sistema
	 */
	private Integer idReservacion;
	/**
	 * Fecha de creaci�n de la reservaci�n en el sistema
	 */
	private Date fechaReservacion;
	/**
	 * N�mero de Mesa asociado a la reservaci�n
	 */
	private String nroMesa;
	/**
	 * Cedula del cliente que realiz� la reservaci�n
	 */
	private String cedulaCliente;
	/**
	 * Determina si una reservacion esta terminada o no en el sistema
	 * 
	 */
	private Boolean terminada;
	/**
	 * Fecha y hora de terminacion de la reservacion
	 */
	private Date fechaTerminada;
	
	public Integer getIdReservacion() {
		return idReservacion;
	}
	public void setIdReservacion(Integer idReservacion) {
		this.idReservacion = idReservacion;
	}
	public Date getFechaReservacion() {
		return fechaReservacion;
	}
	public void setFechaReservacion(Date fechaReservacion) {
		this.fechaReservacion = fechaReservacion;
	}
	public String getNroMesa() {
		return nroMesa;
	}
	public void setNroMesa(String nroMesa) {
		this.nroMesa = nroMesa;
	}
	public String getCedulaCliente() {
		return cedulaCliente;
	}
	public void setCedulaCliente(String cedulaCliente) {
		this.cedulaCliente = cedulaCliente;
	}
	public Boolean getTerminada() {
		return terminada;
	}
	public void setTerminada(Boolean terminada) {
		this.terminada = terminada;
	}
	public Date getFechaTerminada() {
		return fechaTerminada;
	}
	public void setFechaTerminada(Date fechaTerminada) {
		this.fechaTerminada = fechaTerminada;
	}
	
	
	

}

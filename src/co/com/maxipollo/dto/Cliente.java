package co.com.maxipollo.dto;

import java.util.Date;

/**
 * Clase dto para para los datos del cliente
 * @author Johan Martinez & Daniel Loaiza
 *
 */
public class Cliente {
	
	/**
	 * Cedula del cliente
	 */
	private String cedula;
	/**
	 * Nombres del cliente
	 */
	private String nombres;
	/**
	 * Apellidos del cliente
	 */
	private String apellidos;
	/**
	 * Correo electronico del cliente
	 */
	private String email;
	/**
	 * Fecha de creacion del cliente en el sistema
	 */
	private Date fechaCreacion;
	/**
	 * Determina si el cliente esta o no eliminado en el sistema
	 * No se realizará borrado físico sino lógico
	 */
	private Boolean eliminado;
	/**
	 * Fecha de eliminación del cliente en el sistema
	 */
	private Date fechaEliminacion;
	
	public String getCedula() {
		return cedula;
	}
	public void setCedula(String cedula) {
		this.cedula = cedula;
	}
	public String getNombres() {
		return nombres;
	}
	public void setNombres(String nombres) {
		this.nombres = nombres;
	}
	public String getApellidos() {
		return apellidos;
	}
	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Date getFechaCreacion() {
		return fechaCreacion;
	}
	public void setFechaCreacion(Date fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}
	public Boolean getEliminado() {
		return eliminado;
	}
	public void setEliminado(Boolean eliminado) {
		this.eliminado = eliminado;
	}
	public Date getFechaEliminacion() {
		return fechaEliminacion;
	}
	public void setFechaEliminacion(Date fechaEliminacion) {
		this.fechaEliminacion = fechaEliminacion;
	}
	
	

}

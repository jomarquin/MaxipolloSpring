package co.com.maxipollo.dto;

import java.util.Date;

/**
 * Clase dto para los datos de los pedidos
 * @author Johan Martinez & Daniel Loaiza
 *
 */
public class Pedido {
	/**
	 * Identificador del pedido en el sistema
	 */
	private Integer idPedido;
	/**
	 * Fecha en que se realiza el pedido
	 */
	private Date fechaPedido;
	/**
	 * Cedula del cliente que realiza el pedido
	 */
	private String cedulaPedido;
	/**
	 * Valor o costo del pedido realizado
	 */
	private double valorPedido;
	/**
	 * Determina si el pedido esta o no eliminado en el sistema
	 * No se realizará borrado físico sino lógico
	 */
	private Boolean eliminado;
	/**
	 * Fecha de eliminación del pedido en el sistema
	 */
	private Date fechaEliminacion;
	
	public Integer getIdPedido() {
		return idPedido;
	}
	public void setIdPedido(Integer idPedido) {
		this.idPedido = idPedido;
	}
	public Date getFechaPedido() {
		return fechaPedido;
	}
	public void setFechaPedido(Date fechaPedido) {
		this.fechaPedido = fechaPedido;
	}
	public String getCedulaPedido() {
		return cedulaPedido;
	}
	public void setCedulaPedido(String cedulaPedido) {
		this.cedulaPedido = cedulaPedido;
	}
	public double getValorPedido() {
		return valorPedido;
	}
	public void setValorPedido(double valorPedido) {
		this.valorPedido = valorPedido;
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

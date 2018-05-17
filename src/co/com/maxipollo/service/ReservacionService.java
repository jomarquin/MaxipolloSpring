package co.com.maxipollo.service;

import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;

import co.com.maxipollo.dao.ReservacionDAO;
import co.com.maxipollo.dto.Reservacion;
import co.com.maxipollo.exception.MPDaoException;
import co.com.maxipollo.exception.MPServiceException;
import co.com.maxipollo.util.validations.Validaciones;

public class ReservacionService {
	
	private static Logger log = Logger.getLogger(ReservacionService.class);
	private ReservacionDAO reservacionDAO;
	
	public void guardaReservacion(Integer idReservacion, String nroMesa, String cedulaCliente) throws MPDaoException, MPServiceException{
		
		Reservacion reservacion = null;
		
		if(Validaciones.isNumeroVacio(idReservacion)){
			log.error("El id de la reservación no puede ser nulo, ni cadena caracteres vacia");
			throw new MPServiceException("El id de la reservación no puede ser nulo, ni cadena caracteres vacia");
		}
		if(Validaciones.isTextoVacio(nroMesa)){
			log.error("El número de mesa de la reservación no puede ser nulo , ni cadena caracteres vacia");
			throw new MPServiceException("el número de mesa de la reservación no puede ser nulo , ni cadena caracteres vacia");
		}
		if(Validaciones.isTextoVacio(cedulaCliente)){
			log.error("La cedula de quien hace la reservación no puede ser nulo, ni cadena caracteres vacia");
			throw new MPServiceException("La cedula de quien hace la reservación no puede ser nulo, ni cadena caracteres vacia");
		}
		
		reservacion = new Reservacion();
		
		reservacion.setIdReservacion(idReservacion);
		reservacion.setFechaReservacion(new Date());
		reservacion.setNroMesa(nroMesa);
		reservacion.setCedulaCliente(cedulaCliente);
		reservacion.setTerminada(Boolean.FALSE);
		
		reservacionDAO.crear(reservacion);		
	}
	
	public void actualizarReservacion(Integer idReservacion, String nroMesa, String cedulaCliente) throws MPDaoException, MPServiceException{
		
		Reservacion reservacion = null;
		
		if(Validaciones.isNumeroVacio(idReservacion)){
			log.error("El id de la reservación no puede ser nulo, ni cadena caracteres vacia");
			throw new MPServiceException("El id de la reservación no puede ser nulo, ni cadena caracteres vacia");
		}
		if(Validaciones.isTextoVacio(nroMesa)){
			log.error("El número de mesa de la reservación no puede ser nulo , ni cadena caracteres vacia");
			throw new MPServiceException("El número de mesa de la reservación no puede ser nulo , ni cadena caracteres vacia");
		}
		if(Validaciones.isTextoVacio(cedulaCliente)){
			log.error("La cedula de quien hace la reservación no puede ser nulo, ni cadena caracteres vacia");
			throw new MPServiceException("La cedula de quien hace la reservación no puede ser nulo, ni cadena caracteres vacia");
		}
		
		reservacion = reservacionDAO.obtener(idReservacion);
		
		if(reservacion == null){
			log.error("La reservación a modificar no existe en el sistema");
			throw new MPServiceException("La reservación a modificar no existe en el sistema");
		}		
		
		reservacion = new Reservacion();
		
		reservacion.setIdReservacion(idReservacion);
		reservacion.setFechaReservacion(new Date());
		reservacion.setNroMesa(nroMesa);
		reservacion.setCedulaCliente(cedulaCliente);
		reservacion.setTerminada(Boolean.FALSE);
		
		reservacionDAO.modificar(reservacion);			
	}
	
	public void eliminarReservacion(Integer idReservacion, String nroMesa, String cedulaCliente) throws MPDaoException, MPServiceException{
		
		Reservacion reservacion = null;
		
		if(Validaciones.isNumeroVacio(idReservacion)){
			log.error("El id de la reservación no puede ser nulo, ni cadena caracteres vacia");
			throw new MPServiceException("El id de la reservación no puede ser nulo, ni cadena caracteres vacia");
		}
		if(Validaciones.isTextoVacio(nroMesa)){
			log.error("El número de mesa de la reservación no puede ser nulo , ni cadena caracteres vacia");
			throw new MPServiceException("el número de mesa de la reservación no puede ser nulo , ni cadena caracteres vacia");
		}
		if(Validaciones.isTextoVacio(cedulaCliente)){
			log.error("La cedula de quien hace la reservación no puede ser nulo, ni cadena caracteres vacia");
			throw new MPServiceException("La cedula de quien hace la reservación no puede ser nulo, ni cadena caracteres vacia");
		}
		
		reservacion = reservacionDAO.obtener(idReservacion);
		
		if(reservacion == null){
			log.error("La reservación a eliminar no existe en el sistema");
			throw new MPServiceException("La reservación a eliminar no existe en el sistema");
		}		

		reservacion.setTerminada(Boolean.TRUE);
		reservacion.setFechaTerminada(new Date());
		
		reservacionDAO.terminar(reservacion);
	}
	
	public List<Reservacion> obtener() throws MPDaoException{
		return reservacionDAO.obtener();
	}
	
	public Reservacion obtener(Integer idReservacion) throws MPServiceException, MPDaoException{
		if(idReservacion == null && "".equals(idReservacion)){
			log.error("El id de la reservación a buscar no puede ser nulo, ni cadena caracteres vacia");
			throw new MPServiceException("El id de la reservación a buscar no puede ser nulo, ni cadena caracteres vacia");
		}
		return reservacionDAO.obtener(idReservacion);
	}

	public ReservacionDAO getReservacionDAO() {
		return reservacionDAO;
	}

	public void setReservacionDAO(ReservacionDAO reservacionDAO) {
		this.reservacionDAO = reservacionDAO;
	}
	
	

}

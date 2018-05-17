package co.com.maxipollo.service;

import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;

import co.com.maxipollo.dao.ClienteDAO;
import co.com.maxipollo.dto.Cliente;
import co.com.maxipollo.exception.MPDaoException;
import co.com.maxipollo.exception.MPServiceException;
import co.com.maxipollo.util.validations.Validaciones;


public class ClienteService {
	private static Logger log = Logger.getLogger(ClienteService.class);
	private ClienteDAO clienteDAO;
	
	public void guardaCliente(String cedula, String nombres, String apellidos, String 
			email) throws MPDaoException, MPServiceException{
		
		Cliente cliente = null;
		
		if(Validaciones.isTextoVacio(cedula)){
			log.error("La cedula del cliente no puede ser nula, ni cadena caracteres vacia");
			throw new MPServiceException("La cedula del cliente no puede ser nula, ni cadena caracteres vacia");			
		}
		if(Validaciones.isTextoVacio(nombres)){
			log.error("El nombre del cliente no puede ser nulo , ni cadena caracteres vacia");
			throw new MPServiceException("El nombre del cliente no puede ser nulo , ni cadena caracteres vacia");
		}
		if(Validaciones.isTextoVacio(apellidos)){
			log.error("Los apellidos del cliente no puede ser nula, ni cadena caracteres vacia");
			throw new MPServiceException("Los apellidos del cliente no puede ser nula, ni cadena caracteres vacia");
		}
		if(Validaciones.isTextoVacio(email)){
			log.error("El correo del cliente no puede ser nulo , ni cadena caracteres vacia");
			throw new MPServiceException("El correo del cliente no puede ser nulo , ni cadena caracteres vacia");
		}
		
		if(!Validaciones.isEmail(email)){
			log.error("El correo del cliente debe ser valido");
			throw new MPServiceException("El correo del cliente debe ser valido");
			
		}
		
		cliente = new Cliente();
		
		cliente.setCedula(cedula);
		cliente.setNombres(nombres);
		cliente.setApellidos(apellidos);
		cliente.setEmail(email);
		cliente.setFechaCreacion(new Date());
		cliente.setEliminado(Boolean.FALSE);
		
		clienteDAO.insertar(cliente);		
	}
	
	public void actualizarCliente(String cedula, String nombres, String apellidos, String 
			email) throws MPDaoException, MPServiceException{
		
		Cliente cliente = null;
		
		if(Validaciones.isTextoVacio(cedula)){
			log.error("La cedula del cliente no puede ser nula, ni cadena caracteres vacia");
			throw new MPServiceException("La cedula del cliente no puede ser nula, ni cadena caracteres vacia");
		}
		if(Validaciones.isTextoVacio(nombres)){
			log.error("El nombre del cliente no puede ser nulo , ni cadena caracteres vacia");
			throw new MPServiceException("El nombre del cliente no puede ser nulo , ni cadena caracteres vacia");
		}
		if(Validaciones.isTextoVacio(apellidos)){
			log.error("Los apellidos del cliente no puede ser nula, ni cadena caracteres vacia");
			throw new MPServiceException("La cedula del cliente no puede ser nula, ni cadena caracteres vacia");
		}
		if(Validaciones.isTextoVacio(email)){
			log.error("El correo del cliente no puede ser nulo , ni cadena caracteres vacia");
			throw new MPServiceException("El nombre del cliente no puede ser nulo , ni cadena caracteres vacia");
		}
		
		if(!Validaciones.isEmail(email)){
			log.error("El correo del cliente debe ser valido");
			throw new MPServiceException("El correo del cliente debe ser valido");
		}
		
		cliente = clienteDAO.obtener(cedula);
		
		if(cliente == null){
			log.error("El cliente a modificar no existe en el sistema");
			throw new MPServiceException("El cliente a modificar no existe en el sistema");
		}
		
		cliente = new Cliente();
		
		cliente.setCedula(cedula);
		cliente.setNombres(nombres);
		cliente.setApellidos(apellidos);
		cliente.setEmail(email);
		cliente.setFechaCreacion(new Date());
		cliente.setEliminado(Boolean.FALSE);
		
		clienteDAO.modificar(cliente);		
	}
	
	public void eliminarCliente(String cedula, String nombres, String apellidos, String 
			email) throws MPDaoException, MPServiceException{
		
		Cliente cliente = null;
		
		if(Validaciones.isTextoVacio(cedula)){
			log.error("La cedula del cliente no puede ser nula, ni cadena caracteres vacia");
			throw new MPServiceException("La cedula del cliente no puede ser nula, ni cadena caracteres vacia");
		}
		if(Validaciones.isTextoVacio(nombres)){
			log.error("El nombre del cliente no puede ser nulo , ni cadena caracteres vacia");
			throw new MPServiceException("El nombre del cliente no puede ser nulo , ni cadena caracteres vacia");
		}
		if(Validaciones.isTextoVacio(apellidos)){
			log.error("Los apellidos del cliente no puede ser nula, ni cadena caracteres vacia");
			throw new MPServiceException("La cedula del cliente no puede ser nula, ni cadena caracteres vacia");
		}
		if(Validaciones.isTextoVacio(email)){
			log.error("El correo del cliente no puede ser nulo , ni cadena caracteres vacia");
			throw new MPServiceException("El nombre del cliente no puede ser nulo , ni cadena caracteres vacia");
		}
		
		if(!Validaciones.isEmail(email)){
			log.error("El correo del cliente debe ser valido");
			throw new MPServiceException("El correo del cliente debe ser valido");
		}
		
		cliente = clienteDAO.obtener(cedula);
		
		if(cliente == null){
			log.error("El cliente a eliminar no existe en el sistema");
			throw new MPServiceException("El cliente a eliminar no existe en el sistema");
		}
		
		cliente.setEliminado(Boolean.TRUE);
		cliente.setFechaEliminacion(new Date());
		
		clienteDAO.eliminar(cliente);		
	}
	
	public List<Cliente> obtener() throws MPDaoException{
		return clienteDAO.obtener();
	}
	
	public Cliente obtener(String cedula) throws MPServiceException, MPDaoException{
		if(cedula == null && "".equals(cedula)){
			log.error("La cedula del cliente a buscar no puede ser nula, ni cadena caracteres vacia");
			throw new MPServiceException("La cedula del cliente a buscar no puede ser nula, ni cadena caracteres vacia");
		}
		return clienteDAO.obtener(cedula);
	}

	public ClienteDAO getClienteDAO() {
		return clienteDAO;
	}

	public void setClienteDAO(ClienteDAO clienteDAO) {
		this.clienteDAO = clienteDAO;
	}
	
	

}

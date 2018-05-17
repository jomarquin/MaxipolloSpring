package co.com.maxipollo.service;

import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;

import co.com.maxipollo.dao.PedidoDAO;
import co.com.maxipollo.dto.Pedido;
import co.com.maxipollo.exception.MPDaoException;
import co.com.maxipollo.exception.MPServiceException;
import co.com.maxipollo.util.validations.Validaciones;

public class PedidoService {
	
	private static Logger log = Logger.getLogger(PedidoService.class);	
	private PedidoDAO pedidoDAO;
	
	public void guardaPedido(Integer idPedido, String cedulaPedido, Double valorPedido) throws MPDaoException, MPServiceException{
		
		Pedido pedido = null;
		
		if(Validaciones.isNumeroVacio(idPedido)){
			log.error("El id del pedido no puede ser nulo, ni cadena caracteres vacia");
			throw new MPServiceException("El id del pedido no puede ser nulo, ni cadena caracteres vacia");
		}
		if(Validaciones.isTextoVacio(cedulaPedido)){
			log.error("La cedula de quien hace el pedido no puede ser nulo , ni cadena caracteres vacia");
			throw new MPServiceException("La cedula de quien hace el pedido no puede ser nulo , ni cadena caracteres vacia");
		}
		if(Validaciones.isDoubleVacio(valorPedido)){
			log.error("El valor del pedido no puede ser nulo, ni cadena caracteres vacia");
			throw new MPServiceException("El valor del pedido no puede ser nulo, ni cadena caracteres vacia");
		}
		
		pedido = new Pedido();
		
		pedido.setIdPedido(idPedido);
		pedido.setFechaPedido(new Date());
		pedido.setCedulaPedido(cedulaPedido);
		pedido.setValorPedido(valorPedido);
		pedido.setEliminado(Boolean.FALSE);
		
		pedidoDAO.insertar(pedido);		
	}
	
	public void actualizarPedido(Integer idPedido, String cedulaPedido, Double valorPedido) throws MPDaoException, MPServiceException{
		
		Pedido pedido = null;
		
		if(Validaciones.isNumeroVacio(idPedido)){
			log.error("El id del pedido no puede ser nulo, ni cadena caracteres vacia");
			throw new MPServiceException("El id del pedido no puede ser nulo, ni cadena caracteres vacia");
		}
		if(Validaciones.isTextoVacio(cedulaPedido)){
			log.error("La cedula de quien hace el pedido no puede ser nulo , ni cadena caracteres vacia");
			throw new MPServiceException("La cedula de quien hace el pedido no puede ser nulo , ni cadena caracteres vacia");
		}
		if(Validaciones.isDoubleVacio(valorPedido)){
			log.error("El valor del pedido no puede ser nulo, ni cadena caracteres vacia");
			throw new MPServiceException("El valor del pedido no puede ser nulo, ni cadena caracteres vacia");
		}
		
		pedido = pedidoDAO.obtener(idPedido);
		
		if(pedido == null){
			log.error("El pedido a modificar no existe en el sistema");
			throw new MPServiceException("El pedido a modificar no existe en el sistema");
		}		
		
		pedido = new Pedido();
		
		pedido.setIdPedido(idPedido);
		pedido.setFechaPedido(new Date());
		pedido.setCedulaPedido(cedulaPedido);
		pedido.setValorPedido(valorPedido);
		pedido.setEliminado(Boolean.FALSE);
		
		pedidoDAO.modificar(pedido);		
	}
	
	public void eliminarPedido(Integer idPedido, String cedulaPedido, Double valorPedido) throws MPDaoException, MPServiceException{
		
		Pedido pedido = null;
		
		if(Validaciones.isNumeroVacio(idPedido)){
			log.error("El id del pedido no puede ser nulo, ni cadena caracteres vacia");
			throw new MPServiceException("El id del pedido no puede ser nulo, ni cadena caracteres vacia");
		}
		if(Validaciones.isTextoVacio(cedulaPedido)){
			log.error("La cedula de quien hace el pedido no puede ser nulo , ni cadena caracteres vacia");
			throw new MPServiceException("La cedula de quien hace el pedido no puede ser nulo , ni cadena caracteres vacia");
		}
		if(Validaciones.isDoubleVacio(valorPedido)){
			log.error("El valor del pedido no puede ser nulo, ni cadena caracteres vacia");
			throw new MPServiceException("El valor del pedido no puede ser nulo, ni cadena caracteres vacia");
		}
		
		pedido = pedidoDAO.obtener(idPedido);
		
		if(pedido == null){
			log.error("El pedido a eliminar no existe en el sistema");
			throw new MPServiceException("El pedido a eliminar no existe en el sistema");
		}		
		
		pedido.setEliminado(Boolean.TRUE);
		pedido.setFechaEliminacion(new Date());
		
		pedidoDAO.eliminar(pedido);	
	}
	
	public List<Pedido> obtener() throws MPDaoException{
		return pedidoDAO.obtener();
	}
	
	public Pedido obtener(Integer idPedido) throws MPServiceException, MPDaoException{
		if(idPedido == null && "".equals(idPedido)){
			log.error("El id del pedido a buscar no puede ser nulo, ni cadena caracteres vacia");
			throw new MPServiceException("El id del pedido a buscar no puede ser nulo, ni cadena caracteres vacia");
		}
		return pedidoDAO.obtener(idPedido);
	}

	public PedidoDAO getPedidoDAO() {
		return pedidoDAO;
	}

	public void setPedidoDAO(PedidoDAO pedidoDAO) {
		this.pedidoDAO = pedidoDAO;
	}
	
	

}

package co.com.maxipollo.dao;

import java.util.List;

import co.com.maxipollo.dto.Pedido;
import co.com.maxipollo.exception.MPDaoException;


public interface PedidoDAO {
	
	/**
	 * Crea un nuevo pedido en el sistema
	 * @param pedido instancia del pedido a crear
	 * @return pedido insertado
	 * @throws MPDaoException cuando ocurre cualquier error en la comunicacion con la BD
	 */
	public Pedido insertar(Pedido pedido) throws MPDaoException;
	/**
	 * Modifica la informacion de un pedido en el sistema
	 * @param pedido instancia del pedido con los datos a modificar
	 * @return pedido modificado
	 * @throws MPDaoException
	 */
	public Pedido modificar(Pedido pedido) throws MPDaoException;
	/**
	 * Elimina lógicamente un pedido en el sistema
	 * @param pedido instancia del pedido a eliminar
	 * @throws MPDaoException
	 */
	public void eliminar(Pedido pedido) throws MPDaoException;
	/**
	 * Entrega la lista de pedidos existentes en la base de datos 
	 * @return lista de pedidos
	 * @throws MPDaoException Ocurre un error con la conexión.
	 */
	public List<Pedido> obtener() throws MPDaoException;
	
	/**
	 * Entrega los datos de un Pedido dado su de IdPedido
	 * @param IdPedido IdPedido del Pedido a consultar
	 * @return Una instancia de los datos del Pedido obtenido. 
	 * Si no existe un Pedido con el IdPedido, retorna null
	 * @throws IWDaoException Ocurre un error con la base de datos
	 */	
	public Pedido obtener(Integer IdPedido) throws MPDaoException;

}

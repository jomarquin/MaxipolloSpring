package co.com.maxipollo.dao;

import java.util.List;

import co.com.maxipollo.dto.Cliente;
import co.com.maxipollo.exception.MPDaoException;


/**
 * Interfaz que describe los metodos que un cliente puede raelizar contra la base de datos
 * @author Johan Martinez
 *
 */
public interface ClienteDAO {
	/**
	 * Crea un nuevo cliente en el sistema
	 * @param cliente instancia del cliente a crear
	 * @return cliente insertado
	 * @throws MPDaoException cuando ocurre cualquier error en la comunicacion con la BD
	 */
	public Cliente insertar(Cliente cliente) throws MPDaoException;
	/**
	 * Modifica la informacion de un cliente en el sistema
	 * @param cliente instancia del cliente con los datos a modificar
	 * @return cliente modificado
	 * @throws MPDaoException
	 */
	public Cliente modificar(Cliente cliente) throws MPDaoException;
	/**
	 * Elimina lógicamente un cliente en el sistema
	 * @param cliente instancia del cliente a eliminar
	 * @throws MPDaoException
	 */
	public void eliminar(Cliente cliente) throws MPDaoException;
	/**
	 * Entrega la lista de clientes activos en el sistema
	 * @return Lista de clientes
	 * @throws MPDaoException cuando ocurre cualquier error en la comunicacion con la BD
	 */
	public List<Cliente> obtener() throws MPDaoException;
	/**
	 * Entrega la informacion de un cliente buscado por numero de cedula
	 * @param cedula numero de la cedula del cliente a buscar
	 * @return Información del cliente que se busca
	 * @throws MPDaoException
	 */
	public Cliente obtener(String cedula) throws MPDaoException;
}

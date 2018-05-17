package co.com.maxipollo.dao;

import java.util.List;


import co.com.maxipollo.dto.Reservacion;
import co.com.maxipollo.exception.MPDaoException;

public interface ReservacionDAO {
	
	/**
	 * Crea una nueva reservacion en el sistema
	 * @param reservacion instancia de la reservacion a crear
	 * @return reservacion insertado
	 * @throws MPDaoException cuando ocurre cualquier error en la comunicacion con la BD
	 */
	public Reservacion crear(Reservacion reservacion) throws MPDaoException;
	/**
	 * Modifica la informacion de una reservacion en el sistema
	 * @param cliente instancia de la reservacion con los datos a modificar
	 * @return reservacion modificada
	 * @throws MPDaoException
	 */
	public Reservacion modificar(Reservacion reservacion) throws MPDaoException;
	/**
	 * Elimina lógicamente una reservacion en el sistema
	 * @param reservacion instancia de la reservacion a eliminar
	 * @throws MPDaoException
	 */
	public void terminar(Reservacion reservacion) throws MPDaoException;
	/**
	 * Entrega la lista de reservaciones activas en el sistema
	 * @return Lista de reservaciones
	 * @throws MPDaoException cuando ocurre cualquier error en la comunicacion con la BD
	 */
	public List<Reservacion> obtener() throws MPDaoException;
	/**
	 * Entrega la informacion de una reservacion buscado por numero de idReservacion
	 * @param idReservacion numero del idReservacion de la Reservacion a buscar
	 * @return Información de la Reservacion que se busca
	 * @throws MPDaoException
	 */
	public Reservacion obtener(Integer idReservacion) throws MPDaoException;

}

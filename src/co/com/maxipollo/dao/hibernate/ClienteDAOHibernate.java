package co.com.maxipollo.dao.hibernate;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import co.com.maxipollo.dao.ClienteDAO;
import co.com.maxipollo.dto.Cliente;
import co.com.maxipollo.exception.MPDaoException;
import co.com.maxipollo.service.ClienteService;

public class ClienteDAOHibernate extends HibernateDaoSupport implements ClienteDAO {

	private static Logger log = Logger.getLogger(ClienteDAOHibernate.class);
	
	@Override
	public Cliente insertar(Cliente cliente) throws MPDaoException {
		
		Transaction tx = null;
		Session session = null;
		try {
			session = getSession();				
			tx = session.beginTransaction();
			session.save(cliente);
			tx.commit();
		} catch (HibernateException e) {
			log.error(e);
			throw new MPDaoException(e);
		}finally{
			session.close();
		}	
		return cliente;
	}

	@Override
	public Cliente modificar(Cliente cliente) throws MPDaoException {
		Transaction tx = null;
		Session session = null;
		try {
			session = getSession();				
			tx = session.beginTransaction();
			session.update(cliente);
			tx.commit();
		} catch (HibernateException e) {
			log.error(e);
			throw new MPDaoException(e);
		}finally{
			//session.close();
		}	
		return cliente;
	}

	@Override
	public void eliminar(Cliente cliente) throws MPDaoException {
		Transaction tx = null;
		Session session = null;
		try {
			session = getSession();	
			
			tx = session.beginTransaction();
			cliente.setEliminado(true);
			cliente.setFechaEliminacion(new Date());
			session.update(cliente);
			tx.commit();
		} catch (HibernateException e) {
			log.error(e);
			throw new MPDaoException(e);
		}finally{
			//session.close();
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Cliente> obtener() throws MPDaoException {
		List<Cliente> clientes = new ArrayList<Cliente>();
		Session session = null;
		try {
			session = getSession();			
			Criteria criteria = session.createCriteria(Cliente.class);			
			clientes = criteria.list();
		} catch (HibernateException e) {
			log.error(e);
			throw new MPDaoException(e);
		}finally{
			//session.close();
		}		
		return clientes;
	}

	@Override
	public Cliente obtener(String cedula) throws MPDaoException {
		Cliente cliente = null;		
		Session session = null;
		try {
			session = getSession();			
			cliente = (Cliente)session.load(Cliente.class, cedula); 
		} catch (HibernateException e) {
			log.error(e);
			throw new MPDaoException(e);
		}finally{
			//session.close();
		}		
		return cliente;
	}

}

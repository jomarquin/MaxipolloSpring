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

import co.com.maxipollo.dao.PedidoDAO;
import co.com.maxipollo.dto.Pedido;
import co.com.maxipollo.exception.MPDaoException;


public class PedidoDAOHibernate extends HibernateDaoSupport implements PedidoDAO {

	private static Logger log = Logger.getLogger(PedidoDAOHibernate.class);
	
	@Override
	public Pedido insertar(Pedido pedido) throws MPDaoException {
		Transaction tx = null;
		Session session = null;
		try {
			session = getSession();	
			
			tx = session.beginTransaction();
			session.save(pedido);
			tx.commit();
		} catch (HibernateException e) {
			log.error(e);
			throw new MPDaoException(e);
		}finally{
			session.close();
		}	
		return pedido;
	}

	@Override
	public Pedido modificar(Pedido pedido) throws MPDaoException {
		Transaction tx = null;
		Session session = null;
		try {
			session = getSession();	
			
			tx = session.beginTransaction();
			session.update(pedido);
			tx.commit();
		} catch (HibernateException e) {
			log.error(e);
			throw new MPDaoException(e);
		}finally{
			session.close();
		}	
		return pedido;
	}

	@Override
	public void eliminar(Pedido pedido) throws MPDaoException {
		Transaction tx = null;
		Session session = null;
		try {
			session = getSession();	
			
			tx = session.beginTransaction();
			pedido.setEliminado(true);
			pedido.setFechaEliminacion(new Date());
			session.update(pedido);
			tx.commit();
		} catch (HibernateException e) {
			log.error(e);
			throw new MPDaoException(e);
		}finally{
			session.close();
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Pedido> obtener() throws MPDaoException {
		List<Pedido> pedidos = new ArrayList<Pedido>();
		Session session = null;
		try {
			session = getSession();			
			Criteria criteria = session.createCriteria(Pedido.class);			
			pedidos = criteria.list();
		} catch (HibernateException e) {
			log.error(e);
			throw new MPDaoException(e);
		}finally{
			session.close();
		}		
		return pedidos;
	}

	@Override
	public Pedido obtener(Integer IdPedido) throws MPDaoException {
		Pedido pedido = null;		
		Session session = null;
		try {
			session = getSession();			
			pedido = (Pedido)session.load(Pedido.class, IdPedido); 
		} catch (HibernateException e) {
			log.error(e);
			throw new MPDaoException(e);
		}finally{
			//session.close();
		}		
		return pedido;
	}
	


}

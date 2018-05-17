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

import co.com.maxipollo.dao.ReservacionDAO;
import co.com.maxipollo.dto.Reservacion;
import co.com.maxipollo.exception.MPDaoException;

public class ReservacionDAOHibernate extends HibernateDaoSupport implements ReservacionDAO {

	private static Logger log = Logger.getLogger(ReservacionDAOHibernate.class);
	
	@Override
	public Reservacion crear(Reservacion reservacion) throws MPDaoException {
		Transaction tx = null;
		Session session = null;
		try {
			session = getSession();				
			tx = session.beginTransaction();
			session.save(reservacion);
			tx.commit();
		} catch (HibernateException e) {
			log.error(e);
			throw new MPDaoException(e);
		}finally{
			session.close();
		}	
		return reservacion;
	}

	@Override
	public Reservacion modificar(Reservacion reservacion) throws MPDaoException {
		Transaction tx = null;
		Session session = null;
		try {
			session = getSession();				
			tx = session.beginTransaction();
			session.update(reservacion);
			tx.commit();
		} catch (HibernateException e) {
			log.error(e);
			throw new MPDaoException(e);
		}finally{
			session.close();
		}	
		return reservacion;
	}

	@Override
	public void terminar(Reservacion reservacion) throws MPDaoException {
		Transaction tx = null;
		Session session = null;
		try {
			session = getSession();				
			tx = session.beginTransaction();
			reservacion.setTerminada(true);
			reservacion.setFechaTerminada(new Date());
			session.update(reservacion);
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
	public List<Reservacion> obtener() throws MPDaoException {
		List<Reservacion> reservaciones = new ArrayList<Reservacion>();
		Session session = null;
		try {
			session = getSession();			
			Criteria criteria = session.createCriteria(Reservacion.class);			
			reservaciones = criteria.list();
		} catch (HibernateException e) {
			log.error(e);
			throw new MPDaoException(e);
		}finally{
			session.close();
		}		
		return reservaciones;
	}

	@Override
	public Reservacion obtener(Integer idReservacion) throws MPDaoException {
		Reservacion reservacion = null;		
		Session session = null;
		try {
			session = getSession();			
			reservacion = (Reservacion)session.load(Reservacion.class, idReservacion); 
		} catch (HibernateException e) {
			log.error(e);
			throw new MPDaoException(e);
		}finally{
			//session.close();
		}		
		return reservacion;
	}

}

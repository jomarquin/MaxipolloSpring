package co.com.maxipollo.dao.hibernate;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import co.com.maxipollo.dao.ClienteDAO;
import co.com.maxipollo.dto.Cliente;
import co.com.maxipollo.exception.MPDaoException;

@RunWith(SpringJUnit4ClassRunner.class)
@Transactional
@ContextConfiguration(locations = "classpath:configuracion.xml")
public class ClienteDAOHibernateTest {
	
	@Autowired
	ClienteDAO clienteDao;

	@Test
	public void testObtener() {
		List<Cliente> clientes = null;
		try {
			clientes = clienteDao.obtener();
			for(Cliente cliente : clientes){
				System.out.println("Cedula: "+ cliente.getCedula());
				System.out.println("Nombres: "+ cliente.getNombres());
				System.out.println("Apellidos: "+ cliente.getApellidos());
				System.out.println("Email: "+ cliente.getEmail());
				System.out.println("Fecha creacion: "+ cliente.getFechaCreacion());
				System.out.println("=====================================");
			}
			assertTrue(true);
		} catch (MPDaoException e) {
			fail(e.getMessage());
		}
	}

}

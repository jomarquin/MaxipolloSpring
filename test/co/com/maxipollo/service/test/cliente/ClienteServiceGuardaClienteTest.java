package co.com.maxipollo.service.test.cliente;

import static org.junit.Assert.*;

import org.apache.log4j.PropertyConfigurator;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import co.com.maxipollo.exception.MPDaoException;
import co.com.maxipollo.exception.MPServiceException;
import co.com.maxipollo.service.ClienteService;

@RunWith(SpringJUnit4ClassRunner.class)
@Transactional
@ContextConfiguration(locations = "classpath:configuracion.xml")
public class ClienteServiceGuardaClienteTest {

	@Autowired
	ClienteService clienteService;
	
	@Test
	@Rollback(false)
	public void testGuardaCliente() {
		PropertyConfigurator.configure("log4j.properties");
		try {
			clienteService.guardaCliente("42555666", "Marina", "Mantilla", "marina@gmail.com");
		} catch (MPDaoException | MPServiceException e) {
			e.printStackTrace();
			fail(e.getMessage());
		}
		
	}

}

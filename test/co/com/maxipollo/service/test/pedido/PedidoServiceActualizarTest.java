package co.com.maxipollo.service.test.pedido;

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
import co.com.maxipollo.service.PedidoService;

@RunWith(SpringJUnit4ClassRunner.class)
@Transactional
@ContextConfiguration(locations = "classpath:configuracion.xml")
public class PedidoServiceActualizarTest {

	@Autowired
	PedidoService pedidoService;
	
	@Test
	@Rollback(false)
	public void testActualizarPedido() {
		PropertyConfigurator.configure("log4j.properties");
		try {
			pedidoService.actualizarPedido(4, "42940919", 63200.0);
		} catch (MPDaoException | MPServiceException e) {
			e.printStackTrace();
			fail(e.getMessage());
		}
	}

}
